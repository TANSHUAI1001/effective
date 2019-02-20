/**
 * Created by shuai on 2017/2/7.
 */

// there are many ways to implement, here are ten of those implementations
//1
function reverse(s) {
    return s.split("").reverse().join("");
}
//2
function reverse(s) {
    var o = '';
    for (var i = s.length - 1; i >= 0; i--)
        o += s[i];
    return o;
}
//3
function reverse(s) {
    var o = [];
    for (var i = s.length - 1, j = 0; i >= 0; i--, j++)
        o[j] = s[i];
    return o.join('');
}
//4
function reverse(s) {
    var o = [];
    for (var i = 0, len = s.length; i <= len; i++)
        o.push(s.charAt(len - i));
    return o.join('');
}
//5
function reverse(s) {
    var i = s.length,
        o = '';
    while (i > 0) {
        o += s.substring(i - 1, i);
        i--;
    }
    return o;
}
//6
function reverse(s) {
    for (var i = s.length - 1, o = ''; i >= 0; o += s[i--]) { }
    return o;
}
//7
function reverse(s) {
    return (s === '') ? '' : reverse(s.substr(1)) + s.charAt(0);
}
//8
function reverse(s) {
    function rev(s, len, o) {
        return (len === 0) ? o : rev(s, --len, (o += s[len]));
    };
    return rev(s, s.length, '');
}
//9
function reverse(s) {
    s = s.split('');
    var len = s.length,
        halfIndex = Math.floor(len / 2) - 1,
        tmp;


    for (var i = 0; i <= halfIndex; i++) {
        tmp = s[len - i - 1];
        s[len - i - 1] = s[i];
        s[i] = tmp;
    }
    return s.join('');
}
//10
function reverse(s) {
    if (s.length < 2)
        return s;
    var halfIndex = Math.ceil(s.length / 2);
    return reverse(s.substr(halfIndex)) +
        reverse(s.substr(0, halfIndex));
}

var s = "a,b,c,d,e,f,g";
var m = reverse(s);
alert(m);
