const mysql = require('mysql');

const connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'1234',
    database:'homi',
    port:'3306',
});

connection.connect();

connection.query('create table homi (number INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ' +
    'path VARCHAR(200) NOT NULL, ' +
    'date INT NOT NULL, weather VARCHAR(20) NOT NULL, temp INT NOT NULL, week VARCHAR(10) NOT NULL, humidity INT NOT NULL );',(error,results,fields)=>{
    if(error) throw error;
    console.log(results);
});

connection.query('describe homi', (error, results, fields) => {
    if(error) throw error;
    console.log(results);
});

connection.end();