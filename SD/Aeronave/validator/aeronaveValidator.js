const { checkSchema } = require('express-validator');

module.exports = {
    manipulateAeronave: checkSchema({
        nome: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'Nome precisa ter pelo menos 2 caracteres.'
        },
        classeExec: {
            notEmpty: true,
            errorMessage: 'Informe a quantidade de assentos executivos!'
        },
        primClasse: {
            notEmpty: true,
            errorMessage: 'Informe a quantidade de assentos de primeira classe!'
        },
        classeEcon: {
            notEmpty: true,
            errorMessage: 'Informe a quantidade de assentos economicos!'
        },
        pesoMaximo: {
            notEmpty: true,
            errorMessage: 'Informe o peso máximo de carga!'
        }
    })
};
