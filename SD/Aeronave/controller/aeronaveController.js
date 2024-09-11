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
            classeExec: data.classeExec,
            primClasse: data.primClasse,
            classeEcon: data.classeEcon,
            pesoMaximo: data.pesoMaximo,
            cargaEspecial: data.cargaEspecial
        });

        const info = await newAeronave.save();
        res.status(201).json({ info });
    },

    getAeronave: async (req, res) => {
        try {
            const aeronaves = await Aeronave.find();
    
            if (!aeronaves || aeronaves.length === 0) {
                return res.status(404).json({ res: "Nenhuma aeronave encontrada!" });
            }
    
            res.status(200).json({ aeronaves });
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    deleteAeronave: async (req, res) => {
        let idAero = req.query.idAero;

        const idAeronave = await Aeronave.findOneAndDelete({ idAero });

        if (!idAeronave) {
            return res.status(404).json({ res: "Não foi possível deletar o registro!" });
        }
        res.status(200).json({ res: "Registro deletado!", idAeronave });
    },

    updateAeronave: async (req, res) => {
        const errors = validationResult(req);
        
        if (!errors.isEmpty()) {
            return res.status(400).json({
                error: errors.mapped()
            });
        }
    
        let idAero = req.params.idAero || req.query.idAero;
    
        if (!idAero) {
            return res.status(400).json({ error: 'idAero é obrigatório' });
        }
    
        try {
            const { nome, classeExec, primClasse, classeEcon, pesoMaximo, alocado, cargaEspecial } = req.body;
    
            const updatedAeronave = await Aeronave.findOneAndUpdate(
                { idAero },  
                {           
                    $set: {
                        nome,
                        classeExec,
                        primClasse,
                        classeEcon,
                        pesoMaximo,
                        alocado,
                        cargaEspecial
                    }
                },
                { new: true }
            );
    
            if (!updatedAeronave) {
                return res.status(404).json({ error: 'Aeronave não encontrada' });
            }
    
            res.status(200).json({ message: 'Aeronave atualizada com sucesso!', updatedAeronave });
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    updateAlocacao: async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({
                error: errors.mapped()
            });
        }
    
        let idAero = req.query.idAero || req.body.idAero;
    
        if (!idAero) {
            return res.status(400).json({ error: 'ID da aeronave não fornecido.' });
        }
    
        try {
            const updatedAeronave = await Aeronave.findOneAndUpdate(
                { idAero },
                { $set: { alocado: true } }, 
                { new: true } 
            );
     
            if (!updatedAeronave) {
                return res.status(404).json({ error: 'Aeronave não encontrada.' });
            }
    
            res.json(updatedAeronave);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    }
    
    
};
