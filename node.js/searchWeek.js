const db = require('./db');
const server = require('./server');

exports.week = function(req,res){
    db.query("select * from homi where week = ? ", req.body.search, function (err, result, rows) {
        if(err) {
            console.log(err);
        } else {
            //console.log(rows.insertId);
        }

        server.search_array = result;
        //console.log(server.search_array.length);
        //console.log(req.body.search);

        let array = [ ];
        let json = { };

        for(let i = 0; i<server.search_array.length; i++){
            array[i] = "";
            array[i] += server.search_array[i].path;
        }
        json.photos = array;
        console.log(json);

        res.send(json);

    });
}
//searchWeek.js