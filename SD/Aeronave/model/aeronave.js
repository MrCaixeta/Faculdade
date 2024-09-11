const mongoose = require('mongoose');
const autoIncrement = require('mongoose-sequence')(mongoose);
mongoose.Promise = global.Promise;

const modelSchema = new mongoose.Schema({
    idAero: { type: Number, default: 0 },
    nome: String,
    classeExec: Number,
    primClasse: Number,
    classeEcon: Number,
    cargaEspecial: { type: Boolean, default: false },
    pesoMaximo: Number,
    alocado: { type: Boolean, default: false },
    dataRegistro: Date
});

modelSchema.plugin(autoIncrement, { inc_field: 'idAero' });
const modelName = "Aeronave";

if (mongoose.connection && mongoose.connection.models[modelName]) {
    module.exports = mongoose.connection.models[modelName];
} else {
    module.exports = mongoose.connection.model(modelName, modelSchema);
}
