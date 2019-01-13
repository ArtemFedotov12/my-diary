/*function footerToBottom() {
    var browserHeight = $(window).height(),
        footerOuterHeight = $('#footer').outerHeight(true),
        mainHeightMarginPaddingBorder = $('#main').outerHeight(true) - $('#main').height();
    $('#main').css({
        'min-height': browserHeight - footerOuterHeight - mainHeightMarginPaddingBorder,
    });
};
footerToBottom();
$(window).resize(function () {
    footerToBottom();
});*/
/*cosole.log($('#footer').outerHeight(true));*/
/*
console.log(mainHeightMarginPaddingBorder);*/
function footerToBottom() {
    var browserHeight = $(window).height(),
        footerOuterHeight = $('#footer').outerHeight(true),
        mainHeightMarginPaddingBorder = $('#main').outerHeight(true) - $('#main').height();
    $('#main').css({
        'min-height': browserHeight - footerOuterHeight - mainHeightMarginPaddingBorder,
    });
};
footerToBottom();
$(window).resize(function () {
    footerToBottom();
});