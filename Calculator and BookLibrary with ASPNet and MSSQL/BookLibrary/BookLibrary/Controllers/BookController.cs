using System.Data.Entity;
using System.Linq;
using System.Web.Mvc;
using BookLibrary.Models;
using Microsoft.AspNet.Identity;

namespace BookLibrary.Controllers
{
    public class BookController : Controller
    {
        // GET: Book
        public ActionResult Index()
        {
            using (var db = new ApplicationDbContext())
            {
                var books = db.Books.Include(b => b.Author).ToList();

                return View(books);

            }
        }

        // GET: Book/Details/5
        [Authorize]
        public ActionResult Details(int id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b => b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult($"Cannot find book with Id {id}");
                }

                return View(book);

            }

        }

        // GET: Book/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Book/Create
        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Book book)
        {
            using (var db = new ApplicationDbContext())
            {
                var userId = User.Identity.GetUserId();
                book.AuthorId = userId;

                db.Books.Add(book);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        // GET: Book/Edit/5
        [Authorize]
        public ActionResult Edit(int id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult($"Cannot find book with Id {id}");
                }

                return View(book);

            }
        }

        // POST: Book/Edit/5
        [HttpPost]
        [Authorize]
        public ActionResult Edit(int id, Book bookViewModelBook)
        {
            if (bookViewModelBook.Title == null || bookViewModelBook.Description == null)
            {
                return View(bookViewModelBook);
            }

            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b => b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult($"Cannot find book with Id {id}");
                }

                book.Title = bookViewModelBook.Title;
                book.Description = bookViewModelBook.Description;
                db.SaveChanges();
            }

            return RedirectToAction("Details", new {id = id});
        }

        // GET: Book/Delete/5
        [Authorize]
        public ActionResult Delete(int id)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b => b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult($"Cannot find book with Id {id}");
                }

                return View(book);

            }
        }

        // POST: Book/Delete/5
        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Book currentBookbook)
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Find(id);
                if (book == null)
                {
                    return new HttpNotFoundResult($"Cannot find book with Id {id}");
                }

                db.Books.Remove(book);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}
