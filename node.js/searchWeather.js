
const db = require('./db');
const server = require('./server');

exports.weather = function(req,res){
    db.query("select * from homi where weather = ?", req.body.search, function (err, result, rows) {
        if (err) {
            console.log(err);
        } else {
            //console.log(rows.insertId);
        }
        server.search_array = result;
        //console.log(server.search_array.length);  //결과의 개수
        //console.log(req.body.search);  //serach 값
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

//searchWeather.js