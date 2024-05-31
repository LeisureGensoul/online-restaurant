$(document).ready(function() {
    initData();
});

/**
 * 初始化数据
 */
function initData() {
    var rootUrl = 'rootUrl';
    if (!localStorage.getItem(rootUrl))
        localStorage.setItem(rootUrl, 'http://localhost:8080');
}

/**
 * 得到请求跟路径
 * @return {String} rootUrl 请求根路径
 */
function getRootUrl() {
    return 'http://localhost:8080';
}

/**
 * 获取 token
 * @return {String} token 本地存储中的 token
 */
function getToken() {
    return localStorage.getItem('token') || '';
}

/**
 * POST 请求服务器
 * @param {String} uri 请求路径
 * @param {JSON} data 请求数据
 * @return {Object} 接口返回的数据
 */
function postData(uri, data) {
    var rootUrl = getRootUrl();
    var token = getToken();
    var temp;
    $.ajax({
        url: rootUrl + uri,
        type: 'POST',
        headers: {
            token: token
        },
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        success(e) {
            if (e.success) {
                temp = e.data;
            } else {
                console.log(e.message);
            }
        },
        error(e) {
            console.log('连接超时');
        }
    });
    return temp;
}

/**
 * 向服务器发送 GET 请求
 * @param {String} uri 请求路径
 * @param {JSON} data 请求数据
 * @return {Object} 接口返回的数据
 */
function getData(uri, data) {
    var rootUrl = getRootUrl();
    var token = getToken();
    var temp;
    $.ajax({
        url: rootUrl + uri,
        type: 'GET',
        headers: {
            token: token
        },
        data: data,
        dataType: 'json',
        async: false,
        success(e) {
            if (e.success) {
                temp = e;
            } else {
                console.log(e.message);
            }
        },
        error(e) {
            console.log('连接超时');
        }
    });
    return temp;
}
