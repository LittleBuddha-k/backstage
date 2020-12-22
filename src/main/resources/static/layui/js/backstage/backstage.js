function downloadFile(url, name) {
    var $a = $("<a></a>").attr("href", url).attr("download", name);
    $a[0].click();
}