const express = require('express');
const router = express.Router();

const aeronaveController = require('../controller/aeronaveController');
const aeronaveValidator = require('../validator/aeronaveValidator');

router.post('/aeronave/add', aeronaveValidator.manipulateAeronave, aeronaveController.addAeronave);
router.delete('/aeronave/delete', aeronaveController.deleteAeronave);
router.get('/aeronave/list', aeronaveController.getAeronave);
router.put('/aeronave/edit', aeronaveValidator.manipulateAeronave, aeronaveController.updateAeronave);

module.exports = router;
