(function($) {

    $.support.cors = true;
    var serverUrl = "https://api.bidata.com.cn/platform/v3";

    var ignoreCityList = ["保定", "忻州", "鞍山", "白城", "佳木斯", "大兴安岭地区", "大庆", "上海", "常州", "湖州", "合肥", "淮南", "安庆", "宣城", "池州", "宁德", "九江", "景德镇", "萍乡", "郑州", "宜昌", "恩施土家族苗族", "十堰", "郴州", "韶关", "贺州", "百色", "钦州", "海口", "绵阳", "巴中", "泸州", "眉山", "遵义", "临沧", "怒江傈僳族", "宝鸡", "平凉", "玉树藏族", "石嘴山", "吐鲁番地区", "邯郸", "邢台", "朔州", "吕梁", "阿拉善盟", "大连", "本溪", "朝阳", "葫芦岛", "延边朝鲜族", "松原", "鹤岗", "无锡", "镇江", "扬州", "杭州", "嘉兴", "福州", "厦门", "莆田", "泉州", "漳州", "龙岩", "南平", "鹰潭", "抚州", "济宁", "临沂", "开封", "洛阳", "济源", "濮阳", "随州", "湘西土家族苗族", "江门", "梧州", "宜宾", "资阳", "贵阳", "铜仁", "毕节", "玉溪", "拉萨", "张掖", "白银", "海东", "吴忠", "哈密地区", "博尔塔拉蒙古", "衡水", "包头", "乌海", "兴安盟", "锦州", "阜新", "吉林", "齐齐哈尔", "黑河", "伊春", "连云港", "舟山", "黄山", "南昌", "赣州", "东营", "平顶山", "省直辖县级行政区划", "衡阳", "东莞", "三亚", "南充", "广安", "雅安", "广元", "昭通", "大理白族", "楚雄彝族", "迪庆藏族", "日喀则", "陇南", "克孜勒苏柯尔克孜", "昌吉回族", "北京", "天津", "石家庄", "沧州", "锡林郭勒盟", "抚顺", "通化", "辽源", "哈尔滨", "牡丹江", "南京", "衢州", "台州", "滁州", "芜湖", "菏泽", "泰安", "周口", "武汉", "襄阳", "荆州", "荆门", "株洲", "益阳", "怀化", "永州", "广州", "梅州", "汕头", "佛山", "肇庆", "湛江", "河源", "云浮", "南宁", "河池", "北海", "德阳", "黔东南苗族侗族", "昆明", "山南地区", "昌都地区", "榆林", "安康", "金昌", "天水", "海北藏族", "黄南藏族", "果洛藏族", "银川", "固原", "阿勒泰地区", "喀什地区", "张家口", "廊坊", "太原", "晋中", "长治", "临汾", "运城", "通辽", "鄂尔多斯", "沈阳", "铁岭", "盘锦", "长春", "徐州", "淮安", "宿迁", "宿州", "阜阳", "铜陵", "吉安", "烟台", "许昌", "信阳", "鹤壁", "三门峡", "鄂州", "黄石", "咸宁", "阳江", "揭阳", "茂名", "深圳", "珠海", "柳州", "玉林", "达州", "内江", "红河哈尼族彝族", "曲靖", "保山", "那曲地区", "渭南", "铜川", "临夏回族", "海西蒙古族藏族", "中卫", "和田地区", "巴音郭楞蒙古", "阿克苏地区", "晋城", "呼伦贝尔", "赤峰", "巴彦淖尔", "辽阳", "七台河", "苏州", "泰州", "宁波", "金华", "马鞍山", "新余", "德州", "潍坊", "日照", "聊城", "新乡", "南阳", "孝感", "岳阳", "长沙", "常德", "邵阳", "中山", "清远", "来宾", "重庆", "成都", "乐山", "安顺", "黔南布依族苗族", "六盘水", "黔西南布依族苗族", "西安", "延安", "汉中", "庆阳", "武威", "嘉峪关", "酒泉", "西宁", "克拉玛依", "乌鲁木齐", "唐山", "乌兰察布", "丹东", "四平", "白山", "绥化", "鸡西", "双鸭山", "绍兴", "亳州", "济南", "青岛", "威海", "莱芜", "商丘", "焦作", "漯河", "黄冈", "汕尾", "攀枝花", "遂宁", "凉山彝族", "甘孜藏族", "阿坝藏族羌族", "西双版纳傣族", "德宏傣族景颇族", "思茅区", "阿里地区", "商洛", "定西", "海南藏族", "伊犁哈萨克", "承德", "秦皇岛", "大同", "阳泉", "呼和浩特", "营口", "南通", "盐城", "温州", "丽水", "蚌埠", "淮北", "六安", "三明", "上饶", "宜春", "淄博", "滨州", "枣庄", "安阳", "驻马店", "湘潭", "娄底", "张家界", "惠州", "潮州", "防城港", "崇左", "桂林", "贵港", "自贡", "文山壮族苗族", "丽江", "林芝地区", "咸阳", "兰州", "甘南藏族"];

    /**
     * 检查该名称是否需要忽略
     *
     * @param {name} 传入的查询名称
     *
     * @return {boolean} 检查结果：true表示需要忽略；false表示不需要忽略
     *
     */
    var shouldIgnore = function(name) {
        for (var i = 0; i < ignoreCityList.length; i++) {
            var city = ignoreCityList[i];
            if (city == $.trim(name)) return true;
        }
        return false;
    };

    /**
     * 生成n位随机数
     * 
     * @return {string} 生成的n位随机数
     *
     */
    var generateRandom = function(n) {
        var num = "";
        for (var i = 0; i < n; i++) {
            num += parseInt(10 * Math.random());
        }
        return num;
    };

    /**
     * 使用SHA1算法生成签名信息
     *
     * @param {uid} 用户的UID
     * @param {securityKey} 用户对应的安全key
     * @param {random} 生成的随机数
     * @param {timestamp} 时间戳
     *
     * @return {string} 根据规则生成的签名信息
     *
     */
    var signatureData = function(uid, securityKey, random, timestamp) {
        var separator = ";";
        return CryptoJS.SHA1(random + separator + securityKey + separator + timestamp + separator + uid + separator).toString();
    };

    /**
     * 设置xhr的请求头信息
     *
     * @param {xhr} xhr对象
     * @param {uid} 用户UID
     * @param {nonce} 随机数
     * @param {timestamp} 时间戳
     * @param {signature} 签名信息
     *
     */
    var prepareHeader = function(xhr, uid, nonce, timestamp, signature) {
        xhr.setRequestHeader("X-Uid", uid);
        xhr.setRequestHeader("X-Timestamp", timestamp);
        xhr.setRequestHeader("X-Nonce", nonce);
        xhr.setRequestHeader("X-Signature", signature);
    };

    /**
     * 将选中的企业名称发送给服务器
     *
     * @param {enterprise} 选中的企业
     * @param {uid} 用户的UID
     * @param {securityKey} 该用户对应的安全key
     *
     */
    var sendSelectEnterpriseName = function(enterprise, uid, securityKey) {
        var timestamp = new Date().getTime();
        var nonce = generateRandom(10);
        var signature = signatureData(uid, securityKey, nonce, timestamp);

        var data = {
            "queryKey": enterprise.name
        };

        $.ajax({
            "url": serverUrl + "/enterprises/select",
            "type": "POST",
            "dataType": "json",
            "contentType": "application/json",
            "data": JSON.stringify(data),
            "beforeSend": function(xhr) {
                prepareHeader(xhr, uid, nonce, timestamp, signature);
            },
            "success": function(result) {
                if (result.code && result.code != 200) {
                    console.log("Error: " + result.msg);
                }
            },
            "error": function(error) {
                console.log("请求服务器失败");
            }
        });
    };

    var methods = {
        init: function(options) {
            // 在每个元素上执行方法
            return this.each(function() {
                var $this = $(this);

                // 创建一个默认设置对象
                var defaults = {
                    "uid": "",
                    "securityKey": "",
                    "minLength": 3,
                    "size": 20,
                    "items": 10,
                    "delay": 500,
                    "onSelect": function(item) {

                    }
                };

                // 使用extend方法从options和defaults对象中构造出一个settings对象
                var settings = $.extend({}, defaults, options);

                // 执行代码
                $this.typeahead({
                    "items": settings.items,
                    "delay": settings.delay,
                    "source": function(query, process) {
                        if (query && query.length >= settings.minLength && !shouldIgnore(query)) {
                            var timestamp = new Date().getTime();
                            var nonce = generateRandom(10);
                            var signature = signatureData(settings.uid, settings.securityKey, nonce, timestamp);

                            return $.ajax({
                                "url": serverUrl + "/enterprises?key=" + encodeURI(query) + "&size=" + settings.size,
                                "type": "GET",
                                "dataType": "json",
                                "beforeSend": function(xhr) {
                                    prepareHeader(xhr, settings.uid, nonce, timestamp, signature);
                                },
                                "success": function(result) {
                                    if (result.CODE && result.CODE != 200) {
                                        console.log("Error: " + result.msg);
                                    } else {
                                        var arr = [];
                                        for (var i = 0; i < result.ENTERPRISES.length; i++) {
                                            var enterprise = result.ENTERPRISES[i];
                                            enterprise.name = enterprise.ENTNAME;
                                            arr.push(enterprise);
                                        }
                                        process(arr);
                                    }
                                },
                                "error": function(error) {
                                    console.log("请求服务器失败。");
                                }
                            });
                        }
                    },
                    "matcher": function(item) {
                        return true;
                    },
                    "sorter": function(items) {
                        return items;
                    },
                    "highlighter": function(item) {
                        return item;
                    },
                    "updater": function(item) {
                        sendSelectEnterpriseName(item, settings.uid, settings.securityKey);

                        var onSelectCallback = settings.onSelect;
                        if (onSelectCallback && $.isFunction(onSelectCallback)) {
                            onSelectCallback(item);
                        }

                        return item.name;
                    }
                });

            });

        }
    };

    $.fn.enterpriseTypeahead = function() {

        var method = arguments[0];

        if (methods[method]) {
            method = methods[method];

            // 我们的方法是作为参数传入的，把它从参数列表中删除，因为调用方法时并不需要它
            arguments = Array.prototype.slice.call(arguments, 1);

        } else if (typeof(method) == 'object' || !method) {
            // 如果我们传入的是一个对象参数，或者根本没有参数，init方法会被调用
            method = methods.init;
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.enterpriseTypeahead');
            return this;
        }

        // 用apply方法来调用我们的方法并传入参数
        return method.apply(this, arguments);
    };

})(jQuery);