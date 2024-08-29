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
        quantidadeAssentos: {
            notEmpty: true,
            errorMessage: 'Informe a quantidade de assentos!'
        },
        pesoMaximo: {
            notEmpty: true,
            errorMessage: 'Informe o peso máximo de carga!'
        }
    })
};
