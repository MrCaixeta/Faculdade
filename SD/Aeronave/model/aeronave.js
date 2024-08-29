const mongoose = require('mongoose');
const autoIncrement = require('mongoose-sequence')(mongoose);
mongoose.Promise = global.Promise;

const modelSchema = new mongoose.Schema({
    id: { type: Number, default: 0 },
    nome: String,
    quantidadeAssentos: Number,
    cargaEspecial: { type: Boolean, default: false },
    pesoMaximo: String,
    alocado: { type: Boolean, default: false },
    dataRegistro: Date
});

modelSchema.plugin(autoIncrement, { inc_field: 'id' });
const modelName = "Aeronave";

if (mongoose.connection && mongoose.connection.models[modelName]) {
    module.exports = mongoose.connection.models[modelName];
} else {
    module.exports = mongoose.connection.model(modelName, modelSchema);
}
