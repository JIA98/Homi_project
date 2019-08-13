const express = require('express');
const app = express();
const bodyParser = require('body-parser');

//연결할 DB 정보 입력
const insert = require('./insert');
const searchDate = require('./searchDate');
const searchTemp = require('./searchTemp');
const searchWeather = require('./searchWeather');
const searchWeek = require('./searchWeek');

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json());

let search_array ={ };
let find ='';

app.post('/insert',function(req,res){
    insert.data(req,res);
});

app.post('/search_date',function(req,res){
    searchDate.date(req,res);
});

app.post('/search_temp',function(req,res){
    searchTemp.temp(req,res);
});

app.post('/search_weather',function(req,res){
    searchWeather.weather(req,res);
});

app.post('/search_week',function(req,res){
    searchWeek.week(req,res);
});

app.listen(3000,function(){
    console.log('Connected 3000 port!');
});


