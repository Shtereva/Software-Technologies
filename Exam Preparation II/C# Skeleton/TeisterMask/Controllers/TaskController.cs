using System;
using System.Data.Entity;
using System.Linq;
using System.Web.Mvc;
using TeisterMask.Models;

namespace TeisterMask.Controllers
{
    [ValidateInput(false)]
    public class TaskController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new TeisterMaskDbContext())
            {
                var task = db.Tasks.ToList();

                return View(task);

            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Task task)
        {
            using (var db = new TeisterMaskDbContext())
            {
                if (!ModelState.IsValid)
                {
                    return RedirectToAction("Index");
                }
                var createTask = task;
                db.Tasks.Add(createTask);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            using (var db = new TeisterMaskDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task == null)
                {
                    return RedirectToAction("Index");
                }

                return View(task);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int id, Task taskModel)
        {
            using (var db = new TeisterMaskDbContext())
            {
                if (id != taskModel.Id)
                {
                    return RedirectToAction("Index");
                }

                var task = taskModel;
                if (!ModelState.IsValid)
                {
                    return RedirectToAction("Index");
                }

                db.Entry(task).State = EntityState.Modified;
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}