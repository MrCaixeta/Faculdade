require('dotenv').config({ path: 'variable.env' });
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const apiRouters = require('./router/routers');

mongoose.connect(process.env.DATABASE);

mongoose.Promise = global.Promise;
mongoose.connection.on('error', (error) => {
    console.error("Erro:" + error.message);
});

const server = express();

server.use(express.json());
server.use(cors());
server.use('/', apiRouters);

server.listen(process.env.PORT, () => {
    console.log(`Servidor rodando na porta: ${process.env.PORT}`);
});
