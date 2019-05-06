package oom;

/**
 * 测试静态变量的位置
 */
public class ConstOOM {
    public static final String a = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String b = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                        lisdyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String c = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                        alid: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String d = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现d货\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String e = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            sasdfsadfasdch: {\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String j = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documasdf" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String f = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 1asdfasdf,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String g = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8:" +
            "                14:66,\n" +
            "                21asdfasdf67\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String h = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    setTimeout(asdfasdfjhfgn() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        function i(t, e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , a = function() {\n" +
            "                n || (n = !0,\n" +
            "                e())\n" +
            "            }\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
    public static final String i = "/*!\n" +
            "        },\n" +
            "        reCall: function() {\n" +
            "            this.index++,\n" +
            "            this.nextIndex = this.index + 1,\n" +
            "            this.currentImage = this.index < this.maxImgLength ? this.imgArray.get(this.index) : this.imgArray.get(0),\n" +
            "            this.nextImage = this.index < this.maxImgLength - 1 ? this.imgArray.get(this.index + 1) : this.imgArray.get(0),\n" +
            "            this.index = this.index < this.maxImgLength - 1 ? this.index : -1,\n" +
            "            this.nextIndex = this.nextIndex < this.maxImgLength ? this.nextIndex : 0,\n" +
            "            this.swapImg(this.currentImage, this.nextImage)\n" +
            "        },\n" +
            "        swapImg: function(t, e) {\n" +
            "            var i = this;\n" +
            "            this.animate({\n" +
            "                img: t,\n" +
            "                opc: 0,\n" +
            "                complete: function() {\n" +
            "                    $(t).css(\"display\", \"none\"),\n" +
            "                    $(i.currentImage).css(\"opacity\", \"\")\n" +
            "                }\n" +
            "            }),\n" +
            "            $(e).css({\n" +
            "                display: \"list-item\",\n" +
            "                opacity: 0\n" +
            "            }),\n" +
            "            this.animate({\n" +
            "                img: e,\n" +
            "                opc: 1,\n" +
            "                complete: function() {\n" +
            "                    $(i.nextImage).css(\"opacity\", \"\"),\n" +
            "                    i.currentImage = e,\n" +
            "                    i.swapTag.call(i, i.nextIndex),\n" +
            "                    i.intervalCall()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        animate: function(t) {\n" +
            "            var e = this\n" +
            "              , i = $(t.img);\n" +
            "            i.animate({\n" +
            "                opacity: t.opc\n" +
            "            }, {\n" +
            "                duration: e.duration,\n" +
            "                easing: \"swing\",\n" +
            "                step: function() {\n" +
            "                    var e = \"function\" == typeof t.step ? t.step : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                },\n" +
            "                complete: function() {\n" +
            "                    var e = \"function\" == typeof t.complete ? t.complete : function() {}\n" +
            "                    ;\n" +
            "                    e()\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        intervalCall: function() {\n" +
            "            var t = this;\n" +
            "            this.intervalTime = setTimeout(function() {\n" +
            "                t.reCall.call(t),\n" +
            "                clearTimeout(t.intervalTime)\n" +
            "            }, this.swapTime)\n" +
            "        },\n" +
            "        creatImgTags: function() {\n" +
            "            for (var t = $(\".js-tagRoot\"), e = 0; e < this.maxImgLength; e++)\n" +
            "                0 == e ? t.append('<li class=\"current\"></li>') : t.append(\"<li></li>\");\n" +
            "            this.tagArray = $(\".slide-outer\").find(\"li\"),\n" +
            "            this.currentTag = this.tagArray.get(0)\n" +
            "        },\n" +
            "        swapTag: function(t) {\n" +
            "            var e = this.tagArray.get(t);\n" +
            "            this.currentTag && $(this.currentTag).removeClass(\"current\"),\n" +
            "            $(e).addClass(\"current\"),\n" +
            "            this.currentTag = e\n" +
            "        },\n" +
            "        tagEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.tagArray.each(function(e, i) {\n" +
            "                $(i).bind(\"click\", function() {\n" +
            "                    if (!$(this).hasClass(\"current\")) {\n" +
            "                        var i = t.imgArray.get(e);\n" +
            "                        t.imgArray.get(e + 1);\n" +
            "                        clearTimeout(t.intervalTime),\n" +
            "                        t.index = e - 1,\n" +
            "                        t.nextIndex = t.index + 1,\n" +
            "                        $(t.currentImage).stop(!0, !0),\n" +
            "                        $(t.nextImage).stop(!0, !0),\n" +
            "                        t.swapImg(t.currentImage, i),\n" +
            "                        t.swapTag(e)\n" +
            "                    }\n" +
            "                })\n" +
            "            })\n" +
            "        },\n" +
            "        imgEvent: function() {\n" +
            "            var t = this;\n" +
            "            this.imgArray.each(function(e, i) {\n" +
            "                $(i).bind(\"mouseover\", function() {\n" +
            "                    var i = t.imgArray.get(e);\n" +
            "                    $(i).stop(!0, !0),\n" +
            "                    clearTimeout(t.intervalTime)\n" +
            "                }),\n" +
            "                $(i).bind(\"mouseout\", function() {\n" +
            "                    t.intervalCall()\n" +
            "                })\n" +
            "            })\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        swap: function(e) {\n" +
            "            new t(e)\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "+function(t) {\n" +
            "    \"use strict\";\n" +
            "    var e = function(e, i) {\n" +
            "        this.$element = t(e),\n" +
            "        this.$indicators = this.$element.find(\".carousel-indicators\"),\n" +
            "        this.options = i,\n" +
            "        this.paused = this.sliding = this.interval = this.$active = this.$items = null,\n" +
            "        \"hover\" == this.options.pause && this.$element.on(\"mouseenter\", t.proxy(this.pause, this)).on(\"mouseleave\", t.proxy(this.cycle, this))\n" +
            "    };\n" +
            "    e.DEFAULTS = {\n" +
            "        interval: 5e3,\n" +
            "        pause: \"hover\",\n" +
            "        wrap: !0\n" +
            "    },\n" +
            "    e.prototype.cycle = function(e) {\n" +
            "        return e || (this.paused = !1),\n" +
            "        this.interval && clearInterval(this.interval),\n" +
            "        this.options.interval && !this.paused && (this.interval = setInterval(t.proxy(this.next, this), this.options.interval)),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.getActiveIndex = function() {\n" +
            "        return this.$active = this.$element.find(\".carousel-item.active\"),\n" +
            "        this.$items = this.$active.parent().children(),\n" +
            "        this.$items.index(this.$active)\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.to = function(e) {\n" +
            "        var i = this\n" +
            "          , n = this.getActiveIndex();\n" +
            "        if (!(e > this.$items.length - 1 || e < 0))\n" +
            "            return this.sliding ? this.$element.one(\"slid\", function() {\n" +
            "                i.to(e)\n" +
            "            }) : n == e ? this.pause().cycle() : this.slide(e > n ? \"next\" : \"prev\", t(this.$items[e]))\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.pause = function(e) {\n" +
            "        return e || (this.paused = !0),\n" +
            "        this.$element.find(\".next, .prev\").length && t.support.transition.end && (this.$element.trigger(t.support.transition.end),\n" +
            "        this.cycle(!0)),\n" +
            "        this.interval = clearInterval(this.interval),\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.next = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"next\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.prev = function() {\n" +
            "        if (!this.sliding)\n" +
            "            return this.slide(\"prev\")\n" +
            "    }\n" +
            "    ,\n" +
            "    e.prototype.slide = function(e, i) {\n" +
            "        var n = this.$element.find(\".carousel-item.active\")\n" +
            "          , a = i || n[e]()\n" +
            "          , s = this.interval\n" +
            "          , o = \"next\" == e ? \"left\" : \"right\"\n" +
            "          , r = \"next\" == e ? \"first\" : \"last\"\n" +
            "          , l = this;\n" +
            "        if (!a.length) {\n" +
            "            if (!this.options.wrap)\n" +
            "                return;\n" +
            "            a = this.$element.find(\".carousel-item\")[r]()\n" +
            "        }\n" +
            "        this.sliding = !0,\n" +
            "        s && this.pause();\n" +
            "        var d = t.Event(\"slide.bs.carousel\", {\n" +
            "            relatedTarget: a[0],\n" +
            "            direction: o\n" +
            "        });\n" +
            "        if (!a.hasClass(\"active\")) {\n" +
            "            if (this.$indicators.length && (this.$indicators.find(\".active\").removeClass(\"active\"),\n" +
            "            this.$element.one(\"slid\", function() {\n" +
            "                var e = t(l.$indicators.children()[l.getActiveIndex()]);\n" +
            "                e && e.addClass(\"active\")\n" +
            "            })),\n" +
            "            t.support.transition && this.$element.hasClass(\"slide\")) {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                a.addClass(e),\n" +
            "                a[0].offsetWidth,\n" +
            "                n.addClass(o),\n" +
            "                a.addClass(o),\n" +
            "                n.one(t.support.transition.end, function() {\n" +
            "                    a.removeClass([e, o].join(\" \")).addClass(\"active\"),\n" +
            "                    n.removeClass([\"active\", o].join(\" \")),\n" +
            "                    l.sliding = !1,\n" +
            "                    setTimeout(function() {\n" +
            "                        l.$element.trigger(\"slid\")\n" +
            "                    }, 0)\n" +
            "                }).emulateTransitionEnd(600)\n" +
            "            } else {\n" +
            "                if (this.$element.trigger(d),\n" +
            "                d.isDefaultPrevented())\n" +
            "                    return;\n" +
            "                n.removeClass(\"active\"),\n" +
            "                a.addClass(\"active\"),\n" +
            "                this.sliding = !1,\n" +
            "                this.$element.trigger(\"slid\")\n" +
            "            }\n" +
            "            return s && this.cycle(),\n" +
            "            this\n" +
            "        }\n" +
            "    }\n" +
            "    ;\n" +
            "    var i = t.fn.carousel;\n" +
            "    t.fn.carousel = function(i) {\n" +
            "        return this.each(function() {\n" +
            "            var n = t(this)\n" +
            "              , a = n.data(\"bs.carousel\")\n" +
            "              , s = t.extend({}, e.DEFAULTS, n.data(), \"object\" == typeof i && i)\n" +
            "              , o = \"string\" == typeof i ? i : s.slide;\n" +
            "            a || n.data(\"bs.carousel\", a = new e(this,s)),\n" +
            "            \"number\" == typeof i ? a.to(i) : o ? a[o]() : s.interval && a.pause().cycle()\n" +
            "        })\n" +
            "    }\n" +
            "    ,\n" +
            "    t.fn.carousel.Constructor = e,\n" +
            "    t.fn.carousel.noConflict = function() {\n" +
            "        return t.fn.carousel = i,\n" +
            "        this\n" +
            "    }\n" +
            "    ,\n" +
            "    t(document).on(\"click.bs.carousel.data-api\", \"[data-slide], [data-slide-to]\", function(e) {\n" +
            "        var i, n = t(this), a = t(n.attr(\"data-target\") || (i = n.attr(\"href\")) && i.replace(/.*(?=#[^\\s]+$)/, \"\")), s = t.extend({}, a.data(), n.data()), o = n.attr(\"data-slide-to\");\n" +
            "        o && (s.interval = !1),\n" +
            "        a.carousel(s),\n" +
            "        (o = n.attr(\"data-slide-to\")) && a.data(\"bs.carousel\").to(o),\n" +
            "        e.preventDefault()\n" +
            "    }),\n" +
            "    t(window).on(\"load\", function() {\n" +
            "        t('[data-ride=\"carousel\"]').each(function() {\n" +
            "            var e = t(this);\n" +
            "            e.carousel(e.data())\n" +
            "        }),\n" +
            "        t(\"#myCarousel\").on(\"slide.bs.carousel\", function(e) {\n" +
            "            if (!t(e.relatedTarget).hasClass(\"trackviewed\")) {\n" +
            "                var i = t(e.relatedTarget).data(\"trackClick\");\n" +
            "                csdn.track.reportView(i, t(e.relatedTarget), 100),\n" +
            "                t(e.relatedTarget).addClass(\"trackviewed\")\n" +
            "            }\n" +
            "        })\n" +
            "    })\n" +
            "}(window.jQuery),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        var e = '<tr><th width=\"25%\">币名</th><th width=\"43%\">最新价</th><th>涨跌幅(24h)</th></tr>'\n" +
            "          , i = \"\"\n" +
            "          , n = \"\";\n" +
            "        t.coin_data.map(function(t) {\n" +
            "            i = parseFloat(t.change) >= 0 ? \"up\" : \"down\",\n" +
            "            n = parseFloat(t.change) >= 0 ? \"+\" : \"\",\n" +
            "            e += \"<tr><td>\" + t.name + \"</td><td>$ \" + t.price + '</td><td class=\"' + i + '\">' + n + t.change + \"</td></tr>'\"\n" +
            "        }),\n" +
            "        $(\"#coins_table\").html(e);\n" +
            "        var a = t.index_k_data;\n" +
            "        a.spot.trend = parseInt(a.spot.flag) > 0 ? \"up\" : \"down\",\n" +
            "        a.future.trend = parseInt(a.future.flag) > 0 ? \"up\" : \"down\";\n" +
            "        var s = '<dl><dt class=\"' + a.spot.trend + '\">' + a.spot.indexval + '</dt><dd>(现货)<div class=\"' + a.spot.trend + '\">' + a.spot.change + '</div></dd></dl><dl><dt class=\"' + a.future.trend + '\">' + a.future.indexval + '</dt><dd>(期货)<div class=\"' + a.future.trend + '\">' + a.future.change + \"</div></dd></dl>\";\n" +
            "        $(\".coins_dl\").html(s)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = Date.now() - window.localStorage.getItem(\"bitstd_requested_at\"),\n" +
            "        parseInt(a) > 6e4 ? $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: \"/feedapi/bitstd/latestCoinAndKData\",\n" +
            "            success: function(e) {\n" +
            "                localStorage.setItem(\"bitstd_requested_at\", Date.now()),\n" +
            "                t(e),\n" +
            "                localStorage.setItem(\"bitstd_requested_data\", JSON.stringify(e))\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                console.log(t)\n" +
            "            }\n" +
            "        }) : t(JSON.parse(window.localStorage.getItem(\"bitstd_requested_data\")))\n" +
            "    }\n" +
            "    function i() {\n" +
            "        var t = echarts.init(document.getElementById(\"coins_chart\"));\n" +
            "        $.get(\"/feedapi/bitstd/getKline\", function(e) {\n" +
            "            t.setOption(option = {\n" +
            "                title: {\n" +
            "                    text: \"\"\n" +
            "                },\n" +
            "                tooltip: {\n" +
            "                    trigger: \"axis\",\n" +
            "                    position: [0, 3],\n" +
            "                    transitionDuration: 0,\n" +
            "                    formatter: \"时间:{b0} {a0}:{c0} {a1}:{c1}\",\n" +
            "                    backgroundColor: \"#fff\",\n" +
            "                    textStyle: {\n" +
            "                        color: \"#999999\",\n" +
            "                        fontSize: \"10\",\n" +
            "                        fontWeight: 300\n" +
            "                    },\n" +
            "                    padding: 0\n" +
            "                },\n" +
            "                legend: {\n" +
            "                    bottom: 0,\n" +
            "                    data: [\"现货\", \"期货\"]\n" +
            "                },\n" +
            "                xAxis: {\n" +
            "                    boundaryGap: !1,\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisPointer: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        align: \"left\",\n" +
            "                        color: \"#999\",\n" +
            "                        formatter: function(t) {\n" +
            "                            return t.substring(10)\n" +
            "                        }\n" +
            "                    },\n" +
            "                    z: 999,\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[0].slice(0, 16)\n" +
            "                    })\n" +
            "                },\n" +
            "                dataZoom: [{\n" +
            "                    type: \"inside\",\n" +
            "                    xAxisIndex: [0],\n" +
            "                    minSpan: 50,\n" +
            "                    maxSpan: 100\n" +
            "                }],\n" +
            "                grid: [{\n" +
            "                    x: \"0\",\n" +
            "                    y: \"20\",\n" +
            "                    right: \"0\",\n" +
            "                    top: \"20\",\n" +
            "                    height: 179,\n" +
            "                    show: !0,\n" +
            "                    containLabel: !0,\n" +
            "                    borderColor: \"#F5F6F7\"\n" +
            "                }],\n" +
            "                yAxis: {\n" +
            "                    splitLine: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLabel: {\n" +
            "                        inside: !0,\n" +
            "                        showMinLabel: !1,\n" +
            "                        showMaxLabel: !1,\n" +
            "                        color: \"#999\",\n" +
            "                        fontSize: \"10\"\n" +
            "                    },\n" +
            "                    axisTick: {\n" +
            "                        show: !1\n" +
            "                    },\n" +
            "                    axisLine: {\n" +
            "                        lineStyle: {\n" +
            "                            color: \"#F5F6F7\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    min: function(t) {\n" +
            "                        return t.min - 5\n" +
            "                    },\n" +
            "                    max: function(t) {\n" +
            "                        return t.max + 5\n" +
            "                    },\n" +
            "                    z: 999\n" +
            "                },\n" +
            "                series: [{\n" +
            "                    name: \"现货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#FB854F\",\n" +
            "                            borderColor: \"rgba(251, 133, 79, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#FB854F\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.spot.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }, {\n" +
            "                    name: \"期货\",\n" +
            "                    type: \"line\",\n" +
            "                    showSymbol: !1,\n" +
            "                    symbol: \"circle\",\n" +
            "                    symbolSize: 2,\n" +
            "                    z: 997,\n" +
            "                    itemStyle: {\n" +
            "                        normal: {\n" +
            "                            color: \"#984722\",\n" +
            "                            borderColor: \"rgba(152, 71, 34, 0.3)\",\n" +
            "                            borderWidth: 8,\n" +
            "                            lineStyle: {\n" +
            "                                color: \"#984722\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    },\n" +
            "                    emphasis: {\n" +
            "                        label: {\n" +
            "                            position: [0, 0]\n" +
            "                        }\n" +
            "                    },\n" +
            "                    data: e.future.map(function(t) {\n" +
            "                        return t[1]\n" +
            "                    })\n" +
            "                }]\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    var n = null\n" +
            "      , a = \"\";\n" +
            "    $(\"#coins_table\").length > 0 ? (e(),\n" +
            "    i(),\n" +
            "    n = setInterval(function() {\n" +
            "        e()\n" +
            "    }, 6e4)) : clearInterval(n)\n" +
            "}(),\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e(t, e) {\n" +
            "        var i = window.location.protocol + \"//statistic.csdn.net/\";\n" +
            "        $.get(i + t, e)\n" +
            "    }\n" +
            "    function i(i, n) {\n" +
            "        window.not_loading = !1;\n" +
            "        var s, l = \"/api/articles\", d = i;\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: l,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: i,\n" +
            "                category: a,\n" +
            "                shown_offset: n\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                $(\".feed_loading\").show()\n" +
            "            },\n" +
            "            success: function(i) {\n" +
            "                i.articles.length <= 5 && e(\"www\", {\n" +
            "                    category: a,\n" +
            "                    count: i.articles.length\n" +
            "                }),\n" +
            "                $(\".feed_loading\").hide(),\n" +
            "                \"true\" !== i.status ? (window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3)) : (s = i,\n" +
            "                o = s.articles.length,\n" +
            "                window.offset = i.shown_offset,\n" +
            "                o > 0 && (getList(r, s, d, !1, function(t) {\n" +
            "                    $(\".feedlist_mod\").append(t)\n" +
            "                }),\n" +
            "                prompt()),\n" +
            "                t(),\n" +
            "                window.not_loading = !0)\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !1,\n" +
            "                setTimeout(function() {\n" +
            "                    window.not_loading = !0\n" +
            "                }, 3e3),\n" +
            "                console.log(\"数据加d败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n() {\n" +
            "        var t = 0\n" +
            "          , e = 0\n" +
            "          , i = 0;\n" +
            "        return document.body && (e = document.body.scrollTop),\n" +
            "        document.documentElement && (i = document.documentElement.scrollTop),\n" +
            "        t = e - i > 0 ? e : i,\n" +
            "        t = Math.ceil(t)\n" +
            "    }\n" +
            "    var a = $(\"body\").attr(\"data-category\");\n" +
            "    window.offset = parseInt($(\"#feedlist_id\").attr(\"shown-offset\")),\n" +
            "    window.not_loading = !1;\n" +
            "    var s = {\n" +
            "        fund: \"计算机基础\",\n" +
            "        lang: \"编程语言\",\n" +
            "        arch: \"架构\",\n" +
            "        avi: \"音视频开发\",\n" +
            "        sec: \"安全\",\n" +
            "        other: \"其他\"\n" +
            "    };\n" +
            "    s[a] && $(\".nav_more\").children(\"a\").text(s[a]);\n" +
            "    var o = 0\n" +
            "      , r = new listAdFun;\n" +
            "    i(\"more\", window.offset);\n" +
            "    var l, d = 0;\n" +
            "    $(window).on(\"scroll\", function() {\n" +
            "        function t() {\n" +
            "            var t = n();\n" +
            "            1 == window.not_loading && t >= $(document).height() - $(window).height() && i(\"more\", window.offset)\n" +
            "        }\n" +
            "        var e = 300\n" +
            "          , a = (new Date).getTime();\n" +
            "        l || (a - d > 5 * e && (t(),\n" +
            "        d = a),\n" +
            "        l = setTimeout(function() {\n" +
            "            l = null,\n" +
            "            d = (new Date).getTime(),\n" +
            "            t()\n" +
            "        }, e))\n" +
            "    })\n" +
            "});\n" +
            "var listAdFun = function() {\n" +
            "    var t = $(\"body\").attr(\"data-host_type\")\n" +
            "      , e = $(\"#feedlist_id\")\n" +
            "      , i = {\n" +
            "        www: {\n" +
            "            home: {\n" +
            "                3: 435,\n" +
            "                8: 436,\n" +
            "                14: 437,\n" +
            "                21: 438,\n" +
            "                28: 439,\n" +
            "                35: 440,\n" +
            "                42: 474\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 44,\n" +
            "                8: 45,\n" +
            "                14: 46,\n" +
            "                21: 47\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 52,\n" +
            "                8: 115,\n" +
            "                14: 116,\n" +
            "                21: 117\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 122,\n" +
            "                8: 123,\n" +
            "                14: 124,\n" +
            "                21: 125\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 130,\n" +
            "                8: 131,\n" +
            "                14: 132,\n" +
            "                21: 133\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 138,\n" +
            "                8: 139,\n" +
            "                14: 140,\n" +
            "                21: 141\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 146,\n" +
            "                8: 147,\n" +
            "                14: 148,\n" +
            "                21: 149\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 154,\n" +
            "                8: 155,\n" +
            "                14: 156,\n" +
            "                21: 157\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 162,\n" +
            "                8: 163,\n" +
            "                14: 164,\n" +
            "                21: 165\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 170,\n" +
            "                8: 171,\n" +
            "                14: 172,\n" +
            "                21: 173\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 178,\n" +
            "                8: 179,\n" +
            "                14: 180,\n" +
            "                21: 181\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 186,\n" +
            "                8: 187,\n" +
            "                14: 188,\n" +
            "                21: 189\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 194,\n" +
            "                8: 195,\n" +
            "                14: 196,\n" +
            "                21: 197\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 202,\n" +
            "                8: 203,\n" +
            "                14: 204,\n" +
            "                21: 205\n" +
            "            }\n" +
            "        },\n" +
            "        blog: {\n" +
            "            home: {\n" +
            "                3: 211,\n" +
            "                8: 212,\n" +
            "                14: 213,\n" +
            "                21: 214\n" +
            "            },\n" +
            "            news: {\n" +
            "                3: 291,\n" +
            "                8: 292,\n" +
            "                14: 293,\n" +
            "                21: 294\n" +
            "            },\n" +
            "            ai: {\n" +
            "                3: 299,\n" +
            "                8: 300,\n" +
            "                14: 301,\n" +
            "                21: 302\n" +
            "            },\n" +
            "            cloud: {\n" +
            "                3: 307,\n" +
            "                8: 308,\n" +
            "                14: 309,\n" +
            "                21: 310\n" +
            "            },\n" +
            "            blockchain: {\n" +
            "                3: 316,\n" +
            "                8: 317,\n" +
            "                14: 318,\n" +
            "                21: 319\n" +
            "            },\n" +
            "            db: {\n" +
            "                3: 324,\n" +
            "                8: 325,\n" +
            "                14: 326,\n" +
            "                21: 327\n" +
            "            },\n" +
            "            career: {\n" +
            "                3: 332,\n" +
            "                8: 333,\n" +
            "                14: 334,\n" +
            "                21: 335\n" +
            "            },\n" +
            "            game: {\n" +
            "                3: 340,\n" +
            "                8: 341,\n" +
            "                14: 342,\n" +
            "                21: 343\n" +
            "            },\n" +
            "            web: {\n" +
            "                3: 348,\n" +
            "                8: 349,\n" +
            "                14: 350,\n" +
            "                21: 351\n" +
            "            },\n" +
            "            mobile: {\n" +
            "                3: 356,\n" +
            "                8: 357,\n" +
            "                14: 358,\n" +
            "                21: 359\n" +
            "            },\n" +
            "            arch: {\n" +
            "                3: 364,\n" +
            "                8: 365,\n" +
            "                14: 366,\n" +
            "                21: 367\n" +
            "            },\n" +
            "            ops: {\n" +
            "                3: 372,\n" +
            "                8: 373,\n" +
            "                14: 374,\n" +
            "                21: 375\n" +
            "            },\n" +
            "            iot: {\n" +
            "                3: 381,\n" +
            "                8: 382,\n" +
            "                14: 383,\n" +
            "                21: 384\n" +
            "            },\n" +
            "            \"default\": {\n" +
            "                3: 389,\n" +
            "                8: 390,\n" +
            "                14: 391,\n" +
            "                21: 392\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "      , n = {\n" +
            "        judgementAdId: function(e, i) {\n" +
            "            e += 1,\n" +
            "            \"www\" === t ? 3 !== e && 8 !== e && 14 !== e && 21 !== e && 28 !== e && 35 !== e && 42 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow()) : 3 !== e && 8 !== e && 14 !== e && 21 !== e || (this.apendAdItem(e, i),\n" +
            "            this.adShow())\n" +
            "        },\n" +
            "        apendAdItem: function(e, n) {\n" +
            "            var a = _category\n" +
            "              , s = 0;\n" +
            "            switch (a) {\n" +
            "            case \"home\":\n" +
            "                s = i[t].home[e];\n" +
            "                break;\n" +
            "            case \"news\":\n" +
            "                s = i[t].news[e];\n" +
            "                break;\n" +
            "            case \"ai\":\n" +
            "                s = i[t].ai[e];\n" +
            "                break;\n" +
            "            case \"cloud\":\n" +
            "                s = i[t].cloud[e];\n" +
            "                break;\n" +
            "            case \"blockchain\":\n" +
            "                s = i[t].blockchain[e];\n" +
            "                break;\n" +
            "            case \"db\":\n" +
            "                s = i[t].db[e];\n" +
            "                break;\n" +
            "            case \"career\":\n" +
            "                s = i[t].career[e];\n" +
            "                break;\n" +
            "            case \"game\":\n" +
            "                s = i[t].game[e];\n" +
            "                break;\n" +
            "            case \"web\":\n" +
            "                s = i[t].web[e];\n" +
            "                break;\n" +
            "            case \"mobile\":\n" +
            "                s = i[t].mobile[e];\n" +
            "                break;\n" +
            "            case \"arch\":\n" +
            "                s = i[t].arch[e];\n" +
            "                break;\n" +
            "            case \"ops\":\n" +
            "                s = i[t].ops[e];\n" +
            "                break;\n" +
            "            case \"iot\":\n" +
            "                s = i[t].iot[e];\n" +
            "                break;\n" +
            "            default:\n" +
            "                s = i[t][\"default\"][e]\n" +
            "            }\n" +
            "            void 0 !== s && this.loadAdData(s, n)\n" +
            "        },\n" +
            "        loadAdData: function(t, i) {\n" +
            "            $.ajax({\n" +
            "                url: \"https://kunpeng.csdn.net/ad/\" + t,\n" +
            "                type: \"GET\",\n" +
            "                xhrFields: {\n" +
            "                    withCredentials: !0\n" +
            "                },\n" +
            "                crossDomain: !0,\n" +
            "                async: !1,\n" +
            "                success: function(t) {\n" +
            "                    var n = e.find(\"li.tip_box\");\n" +
            "                    \"new\" === i ? n.before(t.con) : e.append(t.con)\n" +
            "                }\n" +
            "            })\n" +
            "        },\n" +
            "        adShow: function() {\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].done = !1,\n" +
            "            reviveAsync[\"8c38e720de1c90a6f6ff52f3f89c4d57\"].start()\n" +
            "        },\n" +
            "        countItemLen: function() {\n" +
            "            var t = e.find(\"li[data-type]\").not('li[data-type=\"ad\"]').length\n" +
            "              , i = e.find('div[id^=\"kp_box_\"]').length + e.find(\"ins\").length\n" +
            "              , t = i + t;\n" +
            "            return t\n" +
            "        }\n" +
            "    };\n" +
            "    this.judgementAdId = function(t, e) {\n" +
            "        n.judgementAdId(t, e)\n" +
            "    }\n" +
            "    ,\n" +
            "    this.countItemLen = function() {\n" +
            "        return n.countItemLen()\n" +
            "    }\n" +
            "};\n" +
            "$.fn.fixedDiv = function(t, e) {\n" +
            "    function i() {\n" +
            "        n = $(document).scrollTop(),\n" +
            "        n > l - o ? (a.addClass(t),\n" +
            "        a.css({\n" +
            "            left: d,\n" +
            "            width: c\n" +
            "        })) : (a.removeClass(t),\n" +
            "        a.css({\n" +
            "            left: 0,\n" +
            "            width: c\n" +
            "        }))\n" +
            "    }\n" +
            "    var n, a = $(this), s = a.height(), o = s * e, r = $(\".feedlist_mod\"), l = r.length > 0 ? r.offset().top : null, d = $(\"main\").offset().left, c = $(\"main\").width();\n" +
            "    r.length > 0 && i(),\n" +
            "    r.length > 0 && $(window).scroll(i)\n" +
            "}\n" +
            ",\n" +
            "$(function() {\n" +
            "    function t() {\n" +
            "        $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "            $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "                $(this).remove()\n" +
            "            })\n" +
            "        })\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.show(),\n" +
            "        $(\".feedlist_mod\").css({\n" +
            "            \"padding-top\": \"0\"\n" +
            "        })\n" +
            "    }\n" +
            "    function i(e) {\n" +
            "        window.not_loading = !1;\n" +
            "        var i, a = \"/api/articles\", s = e;\n" +
            "        $(\".feedlist_mod > li[data-type]\").index($(\".feedlist_mod\").children('li[data-type=\"top\"]:last'));\n" +
            "        $.ajax({\n" +
            "            type: \"GET\",\n" +
            "            url: a,\n" +
            "            dataType: \"json\",\n" +
            "            data: {\n" +
            "                type: e,\n" +
            "                category: _category\n" +
            "            },\n" +
            "            beforeSend: function() {\n" +
            "                var t = $(\".feed-loading-box\").offset().top;\n" +
            "                $(\"body, html\").animate({\n" +
            "                    scrollTop: t\n" +
            "                }, 200, \"linear\")\n" +
            "            },\n" +
            "            success: function(e) {\n" +
            "                if (e.articles.length) {\n" +
            "                    $(\".update_counts\").text(\"已为您更新\" + e.articles.length + \"条内容\");\n" +
            "                    var a = $('#feedlist_id li[data-type=\"top\"]')\n" +
            "                      , o = a.length\n" +
            "                      , d = o ? '#feedlist_id li[data-type=\"top\"]:last' : \"#feedlist_id li[data-type]:first\";\n" +
            "                    $(\".tip_box\")[o ? \"insertAfter\" : \"insertBefore\"](d).show(),\n" +
            "                    r = n(0, r)\n" +
            "                } else\n" +
            "                    $(\".update_counts\").text(\"没有更新的数据\");\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                $(\"div.feed-loading-box\").hide(),\n" +
            "                i = e,\n" +
            "                getList(l, i, s, !0, function(t) {\n" +
            "                    $(\"ul.feedlist_mod\").find(\"li.tip_box\").before(t)\n" +
            "                }),\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".red-dot\").fadeIn(50, \"linear\", function() {\n" +
            "                    var t = this;\n" +
            "                    $(this).fadeOut(4e3),\n" +
            "                    setTimeout(function() {\n" +
            "                        $(t).remove()\n" +
            "                    }, 5e3)\n" +
            "                }),\n" +
            "                t()\n" +
            "            },\n" +
            "            error: function(t) {\n" +
            "                window.not_loading = !0,\n" +
            "                $(\".update_counts\").text(\"数据加载失败\"),\n" +
            "                setTimeout(function() {\n" +
            "                    $(\"div.feed-loading-box\").hide()\n" +
            "                }, 10),\n" +
            "                $(\".msg-tooltip\").slideDown(500, function() {\n" +
            "                    setTimeout(function() {\n" +
            "                        $(\".msg-tooltip\").slideUp(500)\n" +
            "                    }, 2500)\n" +
            "                }),\n" +
            "                console.log(\"数据加载失败！\")\n" +
            "            }\n" +
            "        })\n" +
            "    }\n" +
            "    function n(t, e) {\n" +
            "        function i(t) {\n" +
            "            if (t > 0) {\n" +
            "                if (t < 60)\n" +
            "                    $(\".btn-feed-refresh\").text(t + \"分钟前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 60 && t < 120)\n" +
            "                    $(\".btn-feed-refresh\").text(\"1小时前阅读到这里，点击刷新\");\n" +
            "                else if (t >= 120)\n" +
            "                    return $(\".btn-feed-refresh\").text(\"2小时前阅读到这里，点击刷新\"),\n" +
            "                    void clearInterval(r)\n" +
            "            } else\n" +
            "                $(\".btn-feed-refresh\").text(\"刚刚阅读到这里，点击刷新\")\n" +
            "        }\n" +
            "        clearInterval(e);\n" +
            "        var n, a, s, o, r;\n" +
            "        return n = new Date,\n" +
            "        a = n.getHours(),\n" +
            "        s = n.getMinutes(),\n" +
            "        o = t ? t : 0,\n" +
            "        i(o),\n" +
            "        r = setInterval(function() {\n" +
            "            o += 1,\n" +
            "            i(o)\n" +
            "        }, 6e4)\n" +
            "    }\n" +
            "    $(window).on(\"resize\", function() {\n" +
            "        $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0)\n" +
            "    }),\n" +
            "    $(\".scroll-fixbar\").fixedDiv(\"fix-style\", 0);\n" +
            "    var a = $(\".feed-fix-box\")\n" +
            "      , s = $(\".btn-close-fixbar\");\n" +
            "    _category = $(\"body\").attr(\"data-category\"),\n" +
            "    setTimeout(e, 3e4),\n" +
            "    s.on(\"click\", function() {\n" +
            "        a.hide(),\n" +
            "        setTimeout(e, 3e4)\n" +
            "    }),\n" +
            "    $(\".txt-refrash-new\").on(\"click\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\")\n" +
            "    });\n" +
            "    var o = window.offset.toString();\n" +
            "    o = o.substring(0, o.length - 3),\n" +
            "    o = (new Date).getTime() - o,\n" +
            "    o = parseInt(o / 6e4);\n" +
            "    var r = n(o, null);\n" +
            "    $(\".tip_box\").show(),\n" +
            "    $(document).on(\"click\", \".btn-feed-refresh\", function() {\n" +
            "        s.click(),\n" +
            "        $(\"div.feed-loading-box\").show(),\n" +
            "        i(\"new\"),\n" +
            "        r = n(0, r)\n" +
            "    });\n" +
            "    var l = new listAdFun\n" +
            "}),\n" +
            "function() {\n" +
            "    function t(t) {\n" +
            "        function e() {\n" +
            "            r < 0 && parseInt(o.offsetTop) > i || r > 0 && parseInt(o.offsetTop) < i ? (o.style.top = parseInt(o.offsetTop) + r + \"px\",\n" +
            "            s = setTimeout(e, a)) : (clearInterval(s),\n" +
            "            o.style.top = i + \"px\",\n" +
            "            i <= -o.clientHeight && (o.style.top = \"0px\"))\n" +
            "        }\n" +
            "        var i = parseInt(o.offsetTop) + t\n" +
            "          , n = 300\n" +
            "          , a = 10\n" +
            "          , r = t / (n / a);\n" +
            "        e()\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a = setInterval(function() {\n" +
            "            t(-128)\n" +
            "        }, 3e3)\n" +
            "    }\n" +
            "    function i() {\n" +
            "        clearInterval(a),\n" +
            "        clearInterval(s)\n" +
            "    }\n" +
            "    var n = document.getElementById(\"friendship_container\");\n" +
            "    if (n) {\n" +
            "        var a, s, o = document.getElementById(\"friendship_link\"), r = 0, l = o.getElementsByTagName(\"a\"), d = l.length, c = o.clientHeight;\n" +
            "        if (c > 128) {\n" +
            "            for (var u = 0; u < d; u++) {\n" +
            "                if (r++,\n" +
            "                r > d)\n" +
            "                    return;\n" +
            "                var f = l[u].cloneNode(!0);\n" +
            "                o.appendChild(f)\n" +
            "            }\n" +
            "            n.onmouseover = i,\n" +
            "            n.onmouseout = e,\n" +
            "            e()\n" +
            "        }\n" +
            "    }\n" +
            "}(),\n" +
            "function(t) {\n" +
            "    function e() {\n" +
            "        var t, e;\n" +
            "        t = document.createElement(\"div\"),\n" +
            "        t.innerHTML = i,\n" +
            "        i = null,\n" +
            "        e = t.getElementsByTagName(\"svg\")[0],\n" +
            "        e && (e.setAttribute(\"aria-hidden\", \"true\"),\n" +
            "        e.style.position = \"absolute\",\n" +
            "        e.style.width = 0,\n" +
            "        e.style.height = 0,\n" +
            "        e.style.overflow = \"hidden\",\n" +
            "        r(e, document.body))\n" +
            "    }\n" +
            "    var i = '<svg><symbol id=\"Feed-iconfontcolor39\" viewBox=\"0 0 1025 1024\"><path d=\"M1.984 145.488c0 0-44.976 228.992 293.6 567.568 2.464 2.448 4.832 4.672 7.264 7.088 2.432 2.432 4.656 4.816 7.104 7.28 338.576 338.576 567.568 293.6 567.568 293.6 14.016-1.872 43.472-10.272 53.44-20.272 0 0 52.096-42.816 84.016-95.568 31.936-52.736-28.416-132.304-63.136-167.008-70.048-70.048-134.464-83.712-162.832-64.24-12.752 8.752-63.424 63.36-63.424 63.36-9.984 10-29.744 18.304-43.872 18.48 0 0-88.544 0.896-253.248-161.248C266.32 429.84 267.2 341.296 267.2 341.296c0.192-14.112 8.48-33.888 18.48-43.872 0 0 62.816-62.768 63.36-63.424 23.824-29.824-15.632-103.968-64.24-162.832-31.248-37.84-56.56-59.984-103.904-69.008C117.712-9.872 4.24 74.288 1.984 145.488z\"  ></path></symbol><symbol id=\"Feed-emailsolid\" viewBox=\"0 0 1024 1024\"><path d=\"M960.662975 382.657166c-15.021112 16.495696-32.009018 31.004131-50.019207 43.508933-83.520205 56.507992-167.550017 113.523543-249.065566 172.544775-41.995463 31.006178-94.01728 69.010747-148.517545 69.010747l-0.511653 0-0.509606 0c-54.500265 0-106.524129-38.005592-148.520615-69.010747-81.514525-59.512419-165.54229-116.037806-248.552889-172.544775-18.518772-12.503778-35.508725-27.012214-50.52779-43.508933l0 397.0909c0 44.021609 36.018332 80.000032 80.020498 80.000032l736.181829 0c44.002167 0 80.021521-35.978423 80.021521-80.000032L960.661951 382.657166zM960.662975 235.613182c0-44.002167-36.531008-80.020498-80.021521-80.020498L144.459624 155.592684c-53.516868 0-80.020498 42.016953-80.020498 91.030249 0 45.515636 50.52779 102.019535 86.034469 126.026298 77.505211 54.009078 156.029636 108.035552 233.533824 162.535817 32.517601 22.512736 87.528496 68.518536 128.031978 68.518536l0.509606 0 0.511653 0c40.500413 0 95.512331-46.0058 128.029932-68.518536 77.504188-54.500265 156.031683-108.526739 234.044454-162.535817C919.173025 342.136288 960.662975 291.626917 960.662975 235.613182z\"  ></path></symbol><symbol id=\"Feed-logosina\" viewBox=\"0 0 1024 1024\"><path d=\"M769.104 499.712c-14.368-4.32-24.208-7.232-16.672-26.096 16.272-40.96 17.968-76.304 0.32-101.488-33.088-47.312-123.664-44.752-227.488-1.296 0-0.048-32.576 14.272-24.256-11.6 15.984-51.328 13.568-94.336-11.296-119.152-56.32-56.368-206.064 2.128-334.496 130.512C59.04 466.8 3.2 568.736 3.2 656.88 3.2 825.488 219.408 928 430.944 928c277.296 0 461.76-161.104 461.76-289.008C892.704 561.696 827.6 517.84 769.104 499.712zM431.504 867.568C262.72 884.224 117.008 807.92 106.048 697.12s117.024-214.144 285.792-230.848c168.8-16.688 314.512 59.616 325.488 170.368C728.256 747.52 600.336 850.88 431.504 867.568z\"  ></path><path d=\"M953.248 191.152c-66.976-74.24-165.712-102.544-256.928-83.168l-0.032 0c-21.072 4.512-34.528 25.28-30.016 46.336 4.48 21.088 25.232 34.544 46.336 30.048 64.864-13.776 135.024 6.368 182.656 59.104 47.568 52.736 60.48 124.672 40.096 187.728l0.016 0c-6.656 20.544 4.608 42.528 25.168 49.152 20.48 6.64 42.48-4.592 49.152-25.088 0-0.032 0-0.112 0.016-0.144C1038.304 366.432 1020.256 265.328 953.248 191.152\"  ></path><path d=\"M850.4 283.952c-32.576-36.16-80.72-49.904-125.12-40.448-18.16 3.856-29.728 21.744-25.84 39.904 3.888 18.096 21.728 29.728 39.872 25.776l0 0.032c21.696-4.592 45.248 2.112 61.168 19.744 15.952 17.68 20.256 41.776 13.392 62.912l0.048 0c-5.68 17.648 3.968 36.624 21.632 42.336 17.664 5.664 36.608-3.968 42.32-21.664C891.808 369.344 883.072 320.096 850.4 283.952\"  ></path><path d=\"M448.384 551.568c-80.32-20.912-171.104 19.136-206 89.888-35.536 72.176-1.184 152.336 79.984 178.496 84.048 27.104 183.136-14.416 217.584-92.336C573.92 651.472 531.504 573.04 448.384 551.568zM387.04 735.904c-16.336 26.016-51.28 37.456-77.616 25.424-25.968-11.808-33.616-42.064-17.296-67.472 16.128-25.296 49.92-36.544 76.048-25.584C394.64 679.52 403.072 709.584 387.04 735.904zM440.832 666.864c-5.904 10.096-18.944 14.96-29.184 10.768-10.048-4.16-13.2-15.456-7.504-25.36 5.904-9.856 18.432-14.688 28.464-10.704C442.8 645.28 446.464 656.704 440.832 666.864z\"  ></path></symbol><symbol id=\"Feed-logoqq\" viewBox=\"0 0 1024 1024\"><path d=\"M871.872 508.432c0.992-1.136 1.488-1.744 1.488-1.744 3.36-28.672-37.584-113.776-37.584-113.776s-0.56-0.016-1.456-0.048c0.08-0.752 0.24-1.504 0.288-2.24C851.488 117.776 682.992 0.656 509.44 0.656c-149.952 0-322.544 110.544-318.432 383.904 0 0.688 0.128 1.504 0.256 2.32-0.4 0.992-0.816 1.984-1.232 2.96 0 0-0.016 0-0.016 0.016-41.248 51.008-41.12 116.848-41.12 116.848s0.128 0.16 0.272 0.336C123.76 543.408 35.472 684.64 106.768 799.248c0 0 20.192 22.432 66.528-72.368l0-0.032c21.872 57.776 57.168 105.424 100.304 142.16-46.192 10.576-79.84 30.096-88.72 53.28C179.152 929.696 176 937.632 176 945.888c0 40.912 76.208 74.048 170.208 74.048 79.568 0 137.92-29.232 153.968-63.008 4.4 0.144 8.8 0.304 13.216 0.304 0.656 0 1.296-0.048 1.952-0.048 12.496 35.536 83.072 62.752 168.224 62.752 94.016 0 158.416-40.8 158.416-81.696 0-0.656-0.064-1.312-0.112-1.968 0.048-0.576 0.112-1.136 0.112-1.712 0-28.192-36.224-52.704-89.552-65.184 42.384-36.576 76.784-84.112 97.904-141.952 46.24 94.48 66.384 72.112 66.384 72.112C987.12 686.336 899.248 546.976 871.872 508.432z\"  ></path></symbol><symbol id=\"Feed-youjiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M704 512a22.56 22.56 0 0 0-6.656-15.136l-307.456-307.488a22.72 22.72 0 0 0-15.136-6.56 22.592 22.592 0 0 0-15.136 6.56L326.592 222.4a22.72 22.72 0 0 0-6.56 15.136c0 5.28 2.624 11.232 6.56 15.136L585.888 512l-259.328 259.328a22.72 22.72 0 0 0-6.56 15.136c0 5.952 2.624 11.232 6.56 15.136l33.024 33.024a22.688 22.688 0 0 0 15.136 6.56 22.592 22.592 0 0 0 15.136-6.56l307.488-307.488A22.432 22.432 0 0 0 704 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-zuojiantou\" viewBox=\"0 0 1024 1024\"><path d=\"M320 512c0-5.28 2.688-11.232 6.656-15.136l307.456-307.488a22.72 22.72 0 0 1 15.136-6.56c5.28 0 11.232 2.624 15.136 6.56l33.024 33.024a22.72 22.72 0 0 1 6.56 15.136 22.592 22.592 0 0 1-6.56 15.136L438.112 512l259.328 259.328a22.72 22.72 0 0 1 6.56 15.136 21.312 21.312 0 0 1-6.56 15.136l-33.024 33.024a22.688 22.688 0 0 1-15.136 6.56 22.592 22.592 0 0 1-15.136-6.56l-307.488-307.488A22.432 22.432 0 0 1 320 512z\" fill=\"#707070\" ></path></symbol><symbol id=\"Feed-bokezhuanjia\" viewBox=\"0 0 1024 1024\"><path d=\"M761.738 649.566c22.516-40.788 35.33-87.68 35.33-137.566 0-60.18-18.649-116.005-50.481-162.01a809.43 809.43 0 0 0 33.595-26.268c11.872-9.789 22.229-17.83 31.07-24.126l43.632 37.696 5.2 61.608 32.006 52.9-14.093 60.2 14.093 60.2-32.006 52.9-5.2 61.608-46.786 40.42-23.984 56.987-56.986 23.984-40.42 46.785-61.609 5.2-52.9 32.006-60.2-14.093-60.2 14.093-52.9-32.006-61.608-5.2-40.42-46.785-56.986-23.984-23.985-56.986-46.785-40.42-5.2-61.61-32.006-52.899L146 512l-14.092-60.2 32.005-52.9 5.2-61.608 46.786-40.42 23.985-56.987 56.986-23.984 40.42-46.785 61.609-5.2 52.899-32.006 60.2 14.093 60.2-14.093 52.9 32.006 61.609 5.2 18.506 21.42c-57.121 1.72-107.122 14.936-150.004 39.65a287.324 287.324 0 0 0-43.21-3.253c-157.438 0-285.067 127.629-285.067 285.067S354.562 797.067 512 797.067c100.44 0 188.749-51.945 239.526-130.437h-18.984l4.585-43.48c0.994-9.576 7.166-28.304-22.633-27.602-10.314 0.25-15.429 1.658-15.429 1.658s-0.896 11.571-1.982 20.12l-5.195 49.304H665.02l5.332-48.593 3.524-37.764c86.31-16.207 93.757 12.915 91.089 38.683l-3.227 30.61zM892.09 195.972a827.52 827.52 0 0 1-47.426 49.956c-2.656 2.573-142.25 21.39-155.724 37.349s107.354 5.858 103.7 8.826a780.052 780.052 0 0 1-57.938 42.769c-3.73 2.495-131.538 8.943-144.646 22.09s84.418 14.393 79.586 16.977c-55.831 29.863-120.903 53.973-194.287 73.94-48.39 13.168-89.032 59.492-121.924 138.972-15.206 38.562-24.858 63.566-28.953 75.01-2.262 6.452-13.735 10.513-22.262 7.49s-13.936-13.535-11.236-22.032c57.386-161.968 148.778-289.47 253.092-384.32 23.394-21.27 56.852-37.98 84.14-44.38 114.387-26.825 189.112-23.782 263.877-22.647zM451.126 644.92c7.896 2.874 24.362 5.732 37.679 5.732 14.346 0 22.335-3.958 22.973-10.099 0.581-5.603-5.292-6.36-21.496-10.182-22.387-5.467-36.673-13.931-35.272-27.453 1.626-15.702 22.726-27.57 55.1-27.57 15.784 0 31.087 1.108 39.016 3.696l-2.721 19.8c-5.147-1.783-24.85-4.26-38.175-4.26-13.511 0-20.507 4.235-20.992 8.875-0.609 5.876 6.415 6.15 23.966 10.8 23.768 6.005 34.163 14.462 32.802 27.574-1.594 15.424-20.579 28.537-58.484 28.537-15.78 0-29.379-2.87-36.872-5.735l2.475-19.715z m113.738-66.902c6.16-0.666 15.623-1.345 28.64-1.345 21.739 0 39.314 3.77 50.197 11.692 9.773 7.388 16.276 19.35 14.475 36.68-1.662 16.126-10.08 27.417-22.339 34.4-11.214 6.586-25.346 9.4-46.596 9.4-12.53 0-24.482-0.674-33.573-2.015l9.196-88.813z m17.964 71.161c2.095 0.405 4.848 0.807 10.282 0.807 21.746 0 37.077-10.644 38.619-25.607 2.236-21.63-11.363-29.195-34.276-29.063-2.967 0-7.092 0-9.276 0.397l-5.349 53.466z m-145.07 18.226c-4.6 1.763-14.126 2.965-27.436 2.965-38.279 0-58.94-19.866-56.498-46.128 2.924-31.29 33.533-48.894 67.047-48.894 12.979 0 20.62 1.155 27.781 3.092l-2.298 21.082c-4.762-1.775-15.925-3.402-24.959-3.402-19.718 0-36.467 6.494-38.387 27.035-1.712 18.371 10.045 27.15 32.227 27.15 7.72 0 19.106-1.222 24.368-2.988l-1.844 20.09z\" fill=\"\" ></path></symbol><symbol id=\"Feed-shouji\" viewBox=\"0 0 1024 1024\"><path d=\"M537.754 795.889c-26.41 0-47.893 21.478-47.893 47.892s21.484 47.893 47.893 47.893 47.892-21.479 47.892-47.893-21.483-47.892-47.892-47.892z\"  ></path><path d=\"M774.697 42.071H300.815c-39.864 0-72.3 32.43-72.3 72.3v795.264c0 39.869 32.43 72.3 72.3 72.3h473.872c39.87 0 72.3-32.431 72.3-72.3v-795.27c0.004-39.864-32.426-72.294-72.29-72.294zM300.815 90.266h473.872a24.125 24.125 0 0 1 24.1 24.1v595.809H276.72v-595.81a24.125 24.125 0 0 1 24.094-24.1z m473.882 843.463H300.815a24.125 24.125 0 0 1-24.1-24.1V762.501h522.072V909.63a24.115 24.115 0 0 1-24.09 24.1z\"  ></path></symbol><symbol id=\"Feed-tianxie\" viewBox=\"0 0 1024 1024\"><path d=\"M121.905 780.19h780.19v97.524h-780.19V780.19zM823.296 298.496l-68.974-68.974-344.795 344.796-34.475 103.448 103.424-34.475zM875.008 246.76l17.237-17.238-68.949-68.949-17.262 17.237-17.237 17.238 68.974 68.973z\"  ></path></symbol><symbol id=\"Feed-sousuo\" viewBox=\"0 0 1024 1024\"><path d=\"M1023.972002 964.002812l-59.981188 59.981189-271.443276-271.459276c-166.600191 136.489602-412.812649 126.986048-568.309361-28.494664-165.624236-165.624236-165.624236-434.187647 0-599.859881 165.624236-165.592238 434.187647-165.592238 599.827883 0 155.52871 155.52871 164.984266 401.789166 28.462666 568.389356L1023.972002 964.002812zM663.364906 184.007375c-132.585785-132.585785-347.327719-132.761777-479.705514-0.43198-132.329797 132.345796-132.121807 347.119729 0.463978 479.705514s347.375717 132.793775 479.705514 0.41598c132.329797-132.281799 132.169805-347.10373-0.463978-479.689514z\"  ></path></symbol><symbol id=\"Feed-guanbi\" viewBox=\"0 0 1024 1024\"><path d=\"M1002.211316 933.90818c24.46369 24.46369 29.007633 59.583246 10.159871 78.447007-18.863761 18.863761-53.983317 14.303819-78.447007-10.159871L21.807724 90.09486C-2.655966 65.631169-7.199909 30.495614 11.647853 11.647853c18.863761-18.863761 53.983317-14.303819 78.447007 10.159871L1002.211316 933.90818z\"  ></path><path d=\"M933.92418 21.807724C958.38787-2.655966 993.507426-7.199909 1012.371187 11.647853c18.863761 18.863761 14.303819 53.983317-10.159871 78.447007L90.09486 1002.211316c-24.46369 24.46369-59.583246 29.007633-78.447007 10.159871-18.847761-18.863761-14.303819-53.983317 10.159871-78.463007L933.92418 21.807724z\"  ></path></symbol><symbol id=\"Feed-arrowup\" viewBox=\"0 0 1024 1024\"><path d=\"M764.3229999999999 698.685l-508.831-8.526512829121202e-14c-28.159999999999997-5.329070518200751e-15-50.934-22.598000000000013-50.93399999999999-50.757000000000005 2.6645352591003757e-15-13.093 5.0240000000000045-24.932 13.092000000000006-33.901l251.63300000000004-335.75499999999994c16.859000000000005-22.239999999999995 48.607-26.904999999999998 71.02400000000002-10.04399999999999 3.9469999999999996 2.8710000000000004 7.3549999999999995 6.281000000000001 10.044999999999996 10.045000000000002l254.50999999999993 339.3380000000001c16.675999999999995 22.241000000000003 12.19299999999999 54.16-10.225000000000009 70.844-9.15 6.995999999999998-19.73 10.224999999999994-30.309999999999995 10.224999999999994v0z\"  ></path></symbol><symbol id=\"Feed-arrowright\" viewBox=\"0 0 1024 1024\"><path d=\"M259.677 325.315l508.831-8.526512829121202e-14c28.159999999999997-5.329070518200751e-15 50.934 22.59799999999999 50.934000000000005 50.75699999999999 2.6645352591003757e-15 13.093-5.023999999999994 24.932000000000002-13.091999999999997 33.90100000000001l-251.63299999999992 335.75500000000005c-16.858999999999998 22.240000000000002-48.607 26.905-71.024 10.044000000000011-3.9470000000000005-2.8709999999999996-7.355000000000002-6.280999999999998-10.045000000000002-10.044999999999996l-254.51000000000005-339.33799999999997c-16.676000000000002-22.240999999999996-12.193000000000012-54.16 10.224999999999984-70.844 9.149999999999999-6.996000000000001 19.729999999999997-10.225 30.309999999999995-10.225000000000007v0z\"  ></path></symbol><symbol id=\"Feed-csdnlogo\" viewBox=\"0 0 1024 1024\"><path d=\"M533.941333 419.264c14.709333-1.621333 37.290667-3.264 68.352-3.264 51.872 0 93.802667 9.152 119.776 28.416 23.338667 17.952 38.858667 47.008 34.56 89.130667-3.978667 39.189333-24.042667 66.634667-53.312 83.594666C676.544 633.152 642.837333 640 592.106667 640c-29.888 0-58.421333-1.642667-80.106667-4.896l21.941333-215.84z m42.869334 172.938667c4.981333 0.992 11.562667 1.973333 24.533333 1.973333 51.882667 0 88.469333-25.877333 92.16-62.24 5.333333-52.554667-27.125333-70.944-81.802667-70.624-7.072 0-16.917333 0-22.133333 0.970667L576.8 592.213333h0.010667z m223.498666-164.704c210.954667-39.872 229.162667 31.776 222.645334 95.189333L1010.656 640h-66.944l11.210667-106.986667c2.421333-23.562667 17.504-69.653333-55.338667-67.914666-25.184 0.608-37.706667 4.064-37.706667 4.064s-2.186667 28.469333-4.832 49.514666L844.32 640H778.666667l13.024-119.573333\" fill=\"#231916\" ></path><path d=\"M226.634667 632.682667c-12.373333 4.341333-38.037333 7.317333-73.909334 7.317333C49.6 640-6.048 590.933333 0.522667 526.090667 8.416 448.810667 90.858667 405.333333 181.141333 405.333333c34.976 0 55.552 2.858667 74.858667 7.637334l-6.208 52.064c-12.821333-4.384-42.890667-8.405333-67.232-8.405334-53.141333 0-98.250667 16.042667-103.424 66.762667-4.608 45.354667 27.061333 67.04 86.816 67.04 20.8 0 51.477333-3.018667 65.653333-7.370667l-4.992 49.6 0.021334 0.021334z\" fill=\"#C92027\" ></path><path d=\"M272.714667 580.021333c19.285333 6.762667 59.488 13.504 92 13.504 35.029333 0 54.528-9.333333 56.096-23.797333 1.418667-13.205333-12.928-14.986667-52.490667-24.010667-54.666667-12.896-89.546667-32.842667-86.133333-64.704C286.176 443.989333 337.685333 416 416.725333 416c38.56 0 75.914667 2.613333 95.274667 8.714667l-6.656 46.666666c-12.565333-4.202667-60.672-10.037333-93.205333-10.037333-32.992 0-50.069333 9.973333-51.253334 20.917333-1.493333 13.845333 15.658667 14.485333 58.528 25.450667 58.026667 14.154667 83.402667 34.090667 80.085334 64.992C495.605333 609.109333 449.258667 640 356.714667 640c-38.528 0-71.744-6.762667-90.048-13.525333l6.048-46.453334z\" fill=\"#231916\" ></path></symbol></svg>'\n" +
            "      , n = function() {\n" +
            "        var t = document.getElementsByTagName(\"script\");\n" +
            "        return t[t.length - 1]\n" +
            "    }()\n" +
            "      , a = n.getAttribute(\"data-injectcss\")\n" +
            "      , s = function(e) {\n" +
            "        funasdfasf e) {\n" +
            "            var i = t.document\n" +
            "              , n = !1\n" +
            "              , s = function() {\n" +
            "                try {\n" +
            "                    i.documentElement.doScroll(\"left\")\n" +
            "                } catch (t) {\n" +
            "                    return void setTimeout(s, 50)\n" +
            "                }\n" +
            "                a()\n" +
            "            };\n" +
            "            s(),\n" +
            "            i.onreadystatechange = function() {\n" +
            "                \"complete\" == i.readyState && (i.onreadystatechange = null,\n" +
            "                a())\n" +
            "            }\n" +
            "        }\n" +
            "        if (document.addEventListener)\n" +
            "            if (~[\"complete\", \"loaded\", \"interactive\"].indexOf(document.readyState))\n" +
            "                setTimeout(e, 0);\n" +
            "            else {\n" +
            "                var n = function() {\n" +
            "                    document.removeEventListener(\"DOMContentLoaded\", n, !1),\n" +
            "                    e()\n" +
            "                };\n" +
            "                document.addEventListener(\"DOMContentLoaded\", n, !1)\n" +
            "            }\n" +
            "        else\n" +
            "            document.attachEvent && i(t, e)\n" +
            "    }\n" +
            "      , o = function(t, e) {\n" +
            "        e.parentNode.insertBefore(t, e)\n" +
            "    }\n" +
            "      , r = function(t, e) {\n" +
            "        e.firstChild ? o(t, e.firstChild) : e.appendChild(t)\n" +
            "    };\n" +
            "    if (a && !t.__iconfont__svg__cssinject__) {\n" +
            "        t.__iconfont__svg__cssinject__ = !0;\n" +
            "        try {\n" +
            "            document.write(\"<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>\")\n" +
            "        } catch (l) {\n" +
            "            console && console.log(l)\n" +
            "        }\n" +
            "    }\n" +
            "    s(e)\n" +
            "}(window),\n" +
            "$(\"button.btn-focus\").click(function() {\n" +
            "    $(this).hasClass(\"followed\") ? unGuanzhu($(this)) : guanzhu($(this))\n" +
            "}),\n" +
            "$(\".no-focus-box\").length > 0 && chkGuanzhu(),\n" +
            "prompt(),\n" +
            "$(function() {\n" +
            "    function t(t, e) {\n" +
            "        var i = encodeURIComponent(e)\n" +
            "          , a = \"\";\n" +
            "        a = \"\" == i ? n.attr(\"data-url\") : \"http://so.csdn.net/so/search/s.do?q=\" + i + \"&t=blog\",\n" +
            "        window.open(a)\n" +
            "    }\n" +
            "    function e() {\n" +
            "        a.on(\"click\", function(e) {\n" +
            "            t($(this), $(this).prev(\"input\").val())\n" +
            "        }),\n" +
            "        n.keyup(function(e) {\n" +
            "            var i = e.keyCode;\n" +
            "            13 == i && t($(this), $(this).val())\n" +
            "        })\n" +
            "    }\n" +
            "    var i = $(\".search_bar\")\n" +
            "      , n = $(\".inp_search\")\n" +
            "      , a = $(\".ico_search\");\n" +
            "    n.on(\"focus click\", function(t) {\n" +
            "        t.stopPropagation(),\n" +
            "        t.preventDefault(),\n" +
            "        i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    a.on(\"keyup blur\", function(t) {\n" +
            "        $(document.activeElement).is(\"ico_search\") ? i.removeClass(\"search_bar_fouce\").addClass(\"search_bar_fouce\") : i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    $(document).on(\"click\", function() {\n" +
            "        a.blur(),\n" +
            "        i.removeClass(\"search_bar_fouce\")\n" +
            "    }),\n" +
            "    e()\n" +
            "}),\n" +
            "function() {\n" +
            "    $(\".feedlist_mod\").on(\"click\", \".icon-close\", function(t) {\n" +
            "        if (\"none\" == $(this).siblings(\".unin_reason_dialog\").css(\"display\")) {\n" +
            "            var e = $(this).parents(\"li\").siblings(\"li\");\n" +
            "            $.each(e, function(t, e) {\n" +
            "                var i = $(e).find(\".unin_reason_dialog\");\n" +
            "                \"block\" == i.css(\"display\") && (i.hide(),\n" +
            "                i.siblings(\".icon-close\").removeClass(\"active\"))\n" +
            "            }),\n" +
            "            $(this).addClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeIn()\n" +
            "        } else\n" +
            "            $(this).removeClass(\"active\"),\n" +
            "            $(this).siblings(\".unin_reason_dialog\").fadeOut();\n" +
            "        t.stopPropagation(),\n" +
            "        $(document).click(function() {\n" +
            "            $(t.target).siblings(\".unin_reason_dialog\").fadeOut(),\n" +
            "            $(t.target).removeClass(\"active\")\n" +
            "        })\n" +
            "    }),\n" +
            "    $(\".unin_reason_dialog\").on(\"click\", \".unin_item\", function(t) {\n" +
            "        $(this).parents(\"li.clearfix\").slideUp(\"slow\", function() {\n" +
            "            $(this).remove()\n" +
            "        })\n" +
            "    })\n" +
            "}();\n" +
            "var __mm_over = !1\n" +
            "  , __mm_intro = null;\n" +
            "$(function() {\n" +
            "    var t = $(\".badge div img\");\n" +
            "    0 === t.length ? $(\".interflow .badge\").css({\n" +
            "        paddingTop: 0\n" +
            "    }) : t.hover(m_over_m, m_out_m)\n" +
            "});\n";
}
