package com.example.comeoneinstein.bean

class DataBean {
    var imageRes: Int? = null
    var imageUrl: String? = null
    var title: String?
    var viewType: Int

    constructor(imageRes: Int?, title: String?, viewType: Int) {
        this.imageRes = imageRes
        this.title = title
        this.viewType = viewType
    }

    constructor(imageUrl: String?, title: String?, viewType: Int) {
        this.imageUrl = imageUrl
        this.title = title
        this.viewType = viewType
    }

    companion object {

        //测试数据，如果图片链接失效请更换
        val testData3: List<DataBean>
            get() {
                val list: MutableList<DataBean> = ArrayList()
                list.add(
                    DataBean(
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Ffront%2F400%2Fw700h500%2F20190131%2FTMtN-hshmsti5604365.jpg&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328661&t=8be916e43d87d3372c3a3e9e06ce455d",
                        null,
                        1
                    )
                )
                list.add(
                    DataBean(
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdingyue.ws.126.net%2F2020%2F0322%2F2cc020e3p00q7llme005xc000jz00csc.png&refer=http%3A%2F%2Fdingyue.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328820&t=bc7f2ca11564331fe48a63ca19d864bf",
                        null,
                        1
                    )
                )
                list.add(
                    DataBean(
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fupload-images.jianshu.io%2Fupload_images%2F16150210-9aa82be8a868ab0d.jpeg&refer=http%3A%2F%2Fupload-images.jianshu.io&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328857&t=ae6c39bd79f47cafcc05f17c6a5ffc1d",
                        null,
                        1
                    )
                )
                list.add(
                    DataBean(
                        "https://pics1.baidu.com/feed/500fd9f9d72a6059019b6da980fbff9d013bbad4.jpeg?token=76981544edec0918ad405500976c6bf3",
                        null,
                        1
                    )
                )
                list.add(
                    DataBean(
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0820%252F436935e0p00qy44wb0026c000ht00ajm.png%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328944&t=816cb8936780c32a370a53a452ac0e40",
                        null,
                        1
                    )
                )
                return list
            }
    }
}