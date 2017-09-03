const Product = require('../models/Product');

module.exports = {
	index: (req, res) => {
        Product.find().then(products => {
        	res.render('product/index', {products: products});
		});
    	},
	createGet: (req, res) => {
        res.render('product/create');
	},
	createPost: (req, res) => {
	let product = req.body;

	Product.create(product).then(product => {
		res.redirect('/');
	});
	},
	editGet: (req, res) => {
        let productId = req.params.id;

        Product.findById(productId).then(product => {
        	return res.render('product/edit', product);
		});
	},
	editPost: (req, res) => {
        let productId = req.params.id;
        let product = req.body;

        Product.findByIdAndUpdate(productId, product).then(product => {
            return res.redirect('/');
        });
    }
	};