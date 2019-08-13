
const db = require('./db');

exports.data = function(req,res){
    let sql = 'insert into homi (path, date, weather, temp, week,humidity) values (?,?,?,?,?,?)';
    let weather_receive = req.body.weather;
    let weather = "";
    switch (weather_receive) {
        case 'Mist':
        case 'Smoke':
        case 'Haze':
        case 'Fog':
            weather = 'Mist';
            break;
        case 'Clear':
            weather = 'Clear';
            break;
        case 'Rain':
        case 'Drizzle':
        case 'Thunderstorm':
            weather = 'Rain';
            break;
        case 'Snow':
            weather = 'Snow';
            break;
        case 'Clouds':
        case 'Sand':
        case 'Dust':
            weather = 'Clouds';
            break;

    }
    let params = [req.body.path,req.body.date,weather,req.body.temp,req.body.week, req.body.humidity];
    console.log(req.body.path);
    db.query(sql, params, function (err, rows, fields) {
        if (err) {
            console.log(err);
        } else {
            console.log(rows.insertId);
        }
    });
    res.send(req.body.path);
    console.log(req.body);
}


