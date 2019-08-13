
const db = require('./db');
const server = require('./server');

exports.weather = function(req,res){
    db.query("select * from homi where weather = ?", req.body.search, function (err, result, rows) {
        if (err) {
            console.log(err);
        } else {
            console.log(rows.insertId);
        }
        server.search_array = result;
        console.log(server.search_array.length);

        for(let i = 0; i<server.search_array.length; i++){
            server.find += server.search_array[i].path+"\n";
        }
        console.log(server.find);
        res.send(server.find);

        server.find = ' ';
    });
}


