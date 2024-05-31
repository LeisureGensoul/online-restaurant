// recommend.js
import * as TextEncoding from 'text-encoding-shim';

Page({
    data: {
      sweetness: 0,
      saltiness: 0,
      spiciness: 0,
      avoidances: '',
      outputText: '' // 初始化输出文本内容为空
    },
  
    sliderChange: function(e) {
      const type = e.currentTarget.dataset.type;
      this.setData({
        [type]: e.detail.value
      });
    },
  
    inputChange: function(e) {
      this.setData({
        avoidances: e.detail.value
      });
    },
  
    handleSubmit: function() {
      const preferences = `根据下面信息为顾客推荐三道菜品：甜度等级（1-5）为${this.data.sweetness}，咸度等级（1-5）为${this.data.saltiness}，辣度等级（0-4）为${this.data.spiciness}，忌口是${this.data.avoidances}，菜品有番茄炒蛋、小炒肉、蒜蓉炒时菜、小鸡炖蘑菇、炖甲鱼、牛肉面、牛肉面2、紫菜汤、乌鸡汤、酸辣土豆丝、麻婆豆腐、鱼香肉丝、肉末茄子、炒卷心菜、老坛酸菜牛肉面、糖醋里脊、爆炒腰花、木耳炒山药、孜然羊肉、青椒肉丝、干锅羊头肉、干锅莲藕、干锅土豆片、干锅千页豆腐、干锅鸡爪、干锅脆骨、干锅肥肠、铁板鱿鱼、养身蛤俐汤、酸辣肚丝汤、麻辣虾龙虾、香辣螃蟹腿、小黄鱼、香辣原味田螺、带鱼、米饭、小米粥、八宝粥、红糖糍粑、酒鬼花生、水果拼盘、青岛啤酒、江小白、红星二锅头、可乐、营养快线、王老吉、苦荞茶、铁观音茶、牛肉串、羊肉串、炸鸡、韩式炸鸡`;
      console.log(preferences); // 可以替换为将preferences发送到服务器的代码
      //这里写preferences通过api接口怎么传给ChatGPT
      this.generate(preferences);

    },
    generate(message){
        const gpturl='https://vercel.herowharf.cn'
        let that=this
        var m=""//回复内容
        let req={
            model:"gpt-3.5-turbo",
            messages:[{"role": "system", "content":"为顾客推荐菜品的服务员"},{"role": "user", "content":message}],
            temperature: 0.7,
            stream:true
        }
        const requestTask = wx.request({
        url: gpturl,
        responseType: "arraybuffer",
        method: 'POST',
        enableChunked: true,
        header: {
            'content-type': 'application/json',
            'Authorization':'' 
        },//Token by yourself.
        data:JSON.stringify(req),
        success: (res) => {
            console.log("request success", res);
        },
        fail: (err) => {
            console.log("request fail", err);
        },
        complete: () => {
            // console.log("结束")
        }
        });
        requestTask.onHeadersReceived(function (r) {
        console.log(r);
        });
        requestTask.onChunkReceived(function (r) {
        const arrayBuffer = r.data;
        const uint8Array = new Uint8Array(arrayBuffer);
        var str = new TextEncoding.TextDecoder('utf-8').decode(uint8Array);
        console.log(str)
        while(str.indexOf("content")>0){
            //没结束
            var s1=str.substr(str.indexOf("content")+10)
            var i1=s1.indexOf("\"")
            m+=s1.substr(0,i1)
            // m.replace("\\","")
            m.replace(/\\n/g , '\n')
            var newm="";
            for(let i=0;i<m.length;i++){
                if(m[i]=='\\'){
                    continue;
                }else if(m[i]=='n'){
                    newm+='\n';
                }else{
                    newm+=m[i];
                }
            }
            // m.split("\\n").join(''); // 去掉所有换行符 
            str=s1;
            that.setData({
                outputText:newm
            })
        }
        console.log(that.data.outputText);

        });

    },
    buf2hex(arrayBuffer) {
        return Array.prototype.map.call(new Uint8Array(arrayBuffer), x => ('00' + x.toString(16)).slice(-2)).join('');
    },
    hexToStr(hex) {
        // 去掉字符串首尾空格
        let trimedStr = hex.trim()
        // 判断trimedStr前两个字符是否为0x，如果是则截取从第三个字符及后面所有，否则返回全部字符
        let rawStr = trimedStr.substr(0, 2).toLowerCase() === "0x" ? trimedStr.substr(2) : trimedStr
        // 得到rawStr的长度
        let len = rawStr.length
        // 如果长度不能被2整除，那么传入的十六进制值有误，返回空字符
        if (len % 2 !== 0) {
            return ""
        }
        let curCharCode // 接收每次循环得到的字符
        let resultStr = [] // 存转换后的十进制值数组
        for (let i = 0; i < len; i = i + 2) {
            curCharCode = parseInt(rawStr.substr(i, 2), 16)
            resultStr.push(curCharCode)
        }
        // encoding为空时默认为utf-8
        let bytesView = new Uint8Array(resultStr) // 8 位无符号整数值的类型化数组
        // TextEncoder和TextDecoder对字符串和字节流互转  
        // let str = new TextDecoder(encoding).decode(bytesView)因为小程序中没有TextDecoder,经查阅资料，下载https://github.com/inexorabletash/text-encoding并const encoding = require("./text-encoding-master/lib/encoding.js")引入后使用下面方式即可：
        let str = new TextDecoder("utf-8").decode(bytesView)
        return str
    },
    isUTF8(buffer) {

        var isUtf8 = true;
        var end = buffer.length;
        for (var i = 0; i < end; i++) {
            var temp = buffer[i];
            if ((temp & 0x80) == 0) { // 0xxxxxxx
                continue;
            } else if ((temp & 0xC0) == 0xC0 && (temp & 0x20) == 0) { // 110xxxxx 10xxxxxx
                if (i + 1 < end && (buffer[i + 1] & 0x80) == 0x80 && (buffer[i + 1] & 0x40) == 0) {
                    i = i + 1;
                    continue;
                }
            } else if ((temp & 0xE0) == 0xE0 && (temp & 0x10) == 0) { // 1110xxxx 10xxxxxx 10xxxxxx
                if (i + 2 < end && (buffer[i + 1] & 0x80) == 0x80 && (buffer[i + 1] & 0x40) == 0 &&
                    (buffer[i + 2] & 0x80) == 0x80 && (buffer[i + 2] & 0x40) == 0) {
                    i = i + 2;
                    continue;
                }
            } else if ((temp & 0xF0) == 0xF0 && (temp & 0x08) == 0) { // 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
                if (i + 3 < end && (buffer[i + 1] & 0x80) == 0x80 && (buffer[i + 1] & 0x40) == 0 &&
                    (buffer[i + 2] & 0x80) == 0x80 && (buffer[i + 2] & 0x40) == 0 &&
                    (buffer[i + 3] & 0x80) == 0x80 && (buffer[i + 3] & 0x40) == 0) {
                    i = i + 3;
                    continue;
                }
            }
            isUtf8 = false;
            break;
        }
        return isUtf8;
    },
    arrayBufferToString(arr){
        if(typeof arr === 'string') {  
            return arr;  
        }  
        var dataview=new DataView(arr.data);
        var ints=new Uint8Array(arr.data.byteLength);
        for(var i=0;i<ints.length;i++){
        ints[i]=dataview.getUint8(i);
        }
        arr=ints;
        var str = '',  
            _arr = arr;  
        for(var i = 0; i < _arr.length; i++) {  
            var one = _arr[i].toString(2),  
                v = one.match(/^1+?(?=0)/);  
            if(v && one.length == 8) {  
                var bytesLength = v[0].length;  
                var store = _arr[i].toString(2).slice(7 - bytesLength);  
                for(var st = 1; st < bytesLength; st++) {  
                    store += _arr[st + i].toString(2).slice(2);  
                }  
                str += String.fromCharCode(parseInt(store, 2));  
                i += bytesLength - 1;  
            } else {  
                str += String.fromCharCode(_arr[i]);  
            }  
        }  
        return str; 
    },
  });
  