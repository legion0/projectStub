function URL (url) {
    this.url = String(url);
}

URL.prototype.getParam = function(param) {
    var regex = new RegExp( "(\\?|&)" + param + "=[^&]*");
    if (regex.test(this.url)) {
        var res = this.url.match(regex)[0].toString();
        return res.slice(res.indexOf('=')+1);
    }
    return "";
}

URL.prototype.removeParam = function(param) {
    var regex = new RegExp( "(\\?|&)" + param + "=[^&]*", "gi"); // '?' OR '&' followed by the parameter, then by a '=', then a greedy non '&', then an optional '&'
    if (regex.test(this.url)) {
        this.url = this.url.replace(regex,"");
        if (/(\?|&)$/.test(this.url))
            this.url = this.url.replace(/(\?|&)$/,""); // Delete ? OR & at the end of the URL
        if (!(/\?/.test(this.url)))
            this.url = this.url.replace(/&/,'?'); // Restore the first ? if it went missing by the replace
    }
}

URL.prototype.addParam = function(param,value) {
	this.removeParam(param);
	this.url += '&' + param + '=' + value;
	if (!(/\?/.test(this.url))) this.url = this.url.replace(/&/,'?'); // Replace the first & to ? if there are no ? in the URL
}

URL.prototype.toString = function() {
    return this.url;
}