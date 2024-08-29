const Aeronave = require('../model/aeronave');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addAeronave: async (req, res) => {
        const erros = validationResult(req);

        if (!erros.isEmpty()) {
            return res.status(400).json({ error: erros.mapped() });
        }

        const data = matchedData(req);

        const newAeronave = new Aeronave({
            nome: data.nome,
            dataRegistro: Date.now(),
            quantidadeAssentos: data.quantidadeAssentos,
            pesoMaximo: data.pesoMaximo,
            cargaEspecial: data.cargaEspecial
        });

        const info = await newAeronave.save();
        res.status(201).json({ info });
    },

    getAeronave: async (req, res) => {
        let id = req.query.id;

        const idAeronave = await Aeronave.find({ id });

        if (!idAeronave || idAeronave.length === 0) {
            return res.status(404).json({ res: "Não foi possível encontrar a aeronave!" });
        }
        res.status(200).json({ idAeronave });
    },

    deleteAeronave: async (req, res) => {
        let id = req.query.id;

        const idAeronave = await Aeronave.findOneAndDelete({ id });

        if (!idAeronave) {
            return res.status(404).json({ res: "Não foi possível deletar o registro!" });
        }
        res.status(200).json({ res: "Registro deletado!", idAeronave });
    },

    updateAeronave: async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            res.json({
                error: errors.mapped()
            });
            return;
        }

        let name = req.query.name;

        const data = matchedData(req);

        try {
            const updatedAeronave = await Aeronave.findOneAndUpdate({ name: data.name }, { $set: data });
            if (!updatedAeronave) {
                res.status(404).json({ error: 'Aeronave não encontrada' });
                return;
            }
            res.json(updatedAeronave);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    }
};
