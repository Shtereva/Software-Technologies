const Film = require('../models/Film');

module.exports = {
	index: (req, res) => {
        Film.find().then(films => {
        	res.render('film/index', {films: films});
		});
	},
	createGet: (req, res) => {
        res.render('film/create');
	},
	createPost: (req, res) => {
        let film = req.body;
		if (film.name === "" || film.genre === "" || film.director === "" || film.year === ""){
			res.redirect('/');
		}

        Film.create(film).then(film => {
        	res.redirect('/');
		})
	},
	editGet: (req, res) => {
        let filmId = req.params.id;

        Film.findById(filmId).then(film => {
        	if (film){
        		return res.render('film/edit', film)
			}
			else {
        		return res.redirect('/');
			}
		}).catch(err => res.redirect('/'));
	},
	editPost: (req, res) => {
		let filmId = req.params.id;
		let film = req.body;
        if (!film || film.name === "" || film.genre === "" || film.director === "" || film.year === ""){
            return res.redirect('/');
        }

		Film.findByIdAndUpdate(filmId, film).then(film => {
			res.redirect('/');
		}).catch(err => res.redirect('/'));
	},
	deleteGet: (req, res) => {
        let filmId = req.params.id;

        Film.findById(filmId).then(film => {
            if (film){
                return res.render('film/delete', film)
            }
            else {
                return res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
	},
	deletePost: (req, res) => {
        let filmId = req.params.id;
        let film = req.body;
        if (!film){
            return res.redirect('/');
        }

        Film.findByIdAndRemove(filmId, film).then(film => {
            res.redirect('/');
        }).catch(err => res.redirect('/'));
	}
};