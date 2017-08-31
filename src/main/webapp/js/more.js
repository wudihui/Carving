// function moreNext(){
//     // alert("点老子干啥!");
//     var jQueryObj=$("#name")
//     var start=jQueryObj.val();
//     $.get('portfolio?start='+start+'end'+end,null,back());
//
// }
function moreNext(){
    $.get('portfolio/page_next', back);
}
function moreLast(){
    $.get('portfolio/page_last', back);
}
function back(data) {
    var resultObj = $("#result");
    resultObj.html(data);
}
