// show product list
function showProducts() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/products",
        success: function (data) {
            let products = data;
            let str = "";
            for (i = 0; i < products.length; i++) {
                str += "<tr>";
                str += `<td>${i}</td>`
                str += `<td>${products[i].name}</td>`
                str += `<td>${products[i].brand}</td>`
                str += `<td>${products[i].countryOfOrigin}</td>`
                str += `<td>${products[i].price}</td>`
                str += `<td>${products[i].description}</td>`
                str += `<td><img src="${products[i].img}" height="150" width="200"></td>`
                str += `<td>${products[i].productCategory.categoryName}</td>`
                str += `<td><button type="button" class="btn btn-primary" data-toggle="modal" onclick="showProductUpdateForm(${products[i].id})" data-target="#editModal">Edit</button></td>`
                str += "</tr>"
            }
            document.getElementById("tbody").innerHTML = str;
        },
        error: function (err) {
            console.log(err);
        }
    })
}

showProducts();

// get the product update information
function showProductUpdateForm(productId) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/products/" + productId,
        success: function (data) {
            let productUpdateId = productId
            let product = data;
            let productName = product.name;
            let productBrand = product.brand;
            let productCountryOfOridin = product.countryOfOrigin;
            let productPrice = product.price;
            let productDescription = product.description;
            let productImg = product.img;
            let productCategory = product.productCategory.id;
            $("#nameUpdate").val(productName);
            $("#brandUpdate").val(productBrand);
            $("#countryOfOriginUpdate").val(productCountryOfOridin);
            $("#priceUpdate").val(productPrice);
            $("#descriptionUpdate").val(productDescription);
            $("#imgUpdate").val(productImg);
            $("#categoryUpdate").val(productCategory);
            $("#saveProductUpdate").html(`<td><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button></td>
                 <td><button type="button" class="btn btn-primary" onclick="saveChanges(${productUpdateId})" data-dismiss="modal"  >Save</button></td>`);



        },
        error: function (err) {
            console.error();
        }

    })


}

// save the product update information

function saveChanges(productUpdateId) {
    let name = $("#nameUpdate").val();
    let brand = $("#brandUpdate").val();
    let countryOfOrigin = $("#countryOfOriginUpdate").val();
    let price = $("#priceUpdate").val();
    let description = $("#descriptionUpdate").val();
    let img = $("#imgUpdate").val();
    let category = $("#categoryUpdate").val();
    let productUpdate = {
        id: productUpdateId,
        name : name,
        brand : brand,
        countryOfOrigin : countryOfOrigin,
        price : price,
        description : description,
        img : img,
        productCategory : {
            id : category
        }
    }
    $.ajax({
        type : "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url : "http://localhost:8080/products" ,
        data: JSON.stringify(productUpdate),
        success: function (){
            showProducts();
            alert("success");
        },
        error : function (err) {
            console.log(err);
        }
    })


}