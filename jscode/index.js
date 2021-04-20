// load data from any api server
// url 

fetch('http://localhost:8080/api/products')
.then(response => response.text())
.then(data =>{
    console.log(data)
})