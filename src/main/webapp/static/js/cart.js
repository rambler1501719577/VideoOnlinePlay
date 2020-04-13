$(document).ready(function(){
    calculatorAmount();
    deleteGoodsItem();
});

function calculatorAmount() {
    var totalPrice = 0;
    $(".goods_item").each(function(){
        var num = $(this).find(".amount").text();
        var price = $(this).find(".price").text();
        totalPrice += (num * price);
    });
    $(".totalPrice").text(totalPrice);
}

function deleteGoodsItem() {
    $(".delete").each(function () {
        $(this).click(function () {
           $(this).parent().parent().remove();
           calculatorAmount();
        })
    });
}