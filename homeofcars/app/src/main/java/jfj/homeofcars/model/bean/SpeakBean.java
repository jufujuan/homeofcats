package jfj.homeofcars.model.bean;

import java.util.List;

/**
 * 说客的实体类
 */
public class SpeakBean {

    /**
     * returncode : 0
     * message :
     * result : {"total":11882,"isloadmore":true,"list":[{"id":546680,"title":"三星80亿美元收购哈曼，向汽车领域扩张","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g22/M14/7B/30/160x120_0_autohomecar__wKgFVlgqrI-AZGy3AADnXhAii1k636.jpg","replycount":24,"pagecount":1,"jumppage":1,"updatetime":"20161115144150","lastid":"20161115150000546680"},{"id":546454,"title":"斯柯达柯迪亚克 中文名会否再次拌了脚 ","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g23/M06/7E/69/160x120_0_autohomecar__wKgFXFgpakGAbFgjAALRR5WeX0M171.jpg","replycount":121,"pagecount":1,"jumppage":1,"updatetime":"20161115095433","lastid":"20161115143000546454"},{"id":546523,"title":"众泰竟然是中国小型SUV开山鼻祖？","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g13/M10/9E/E8/160x120_0_autohomecar__wKgH41gqei-AF87eAAG3_NaCl3w770.jpg","replycount":49,"pagecount":1,"jumppage":1,"updatetime":"20161115110001","lastid":"20161115140000546523"},{"id":546451,"title":"2017款大众高尔夫 它叫高8还是高7.5？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g12/M12/9E/B8/160x120_0_autohomecar__wKjBy1gqmdaAcnvrAAeJv8PGCV8377.jpg","replycount":120,"pagecount":1,"jumppage":1,"updatetime":"20161115131504","lastid":"20161115130000546451"},{"id":546446,"title":"体验宝马7系E38--男人的蓝天白云梦！","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g15/M10/9D/DC/160x120_0_autohomecar__wKjByFgpb5mASjq1AAICcKnMya0912.jpg","replycount":81,"pagecount":1,"jumppage":1,"updatetime":"20161114160246","lastid":"20161115120000546446"},{"id":546592,"title":"大众销量依赖中国市场 新SUV帮忙or添乱","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g22/M12/7E/FB/160x120_0_autohomecar__wKgFW1gqekuAT4miAARhDOwCPjo968.jpg","replycount":427,"pagecount":1,"jumppage":1,"updatetime":"20161115110028","lastid":"20161115114500546592"},{"id":546555,"title":"银十的喜与忧|车市10月销量数据报告","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g19/M09/7D/65/160x120_0_autohomecar__wKjBxFgqUWGAQ3d-AAN7Q5B1FIU247.jpg","replycount":67,"pagecount":1,"jumppage":1,"updatetime":"20161115095934","lastid":"20161115110000546555"},{"id":546560,"title":"问答集锦：10万预算能买到后驱车吗？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g18/M08/9D/4E/160x120_0_autohomecar__wKjBxVgqZAOAOHB6AAP5hrBYysQ720.jpg","replycount":154,"pagecount":1,"jumppage":1,"updatetime":"20161115092557","lastid":"20161115103000546560"},{"id":546202,"title":"5-6万能买辆什么样的二手车？--德系篇","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M12/77/B4/160x120_0_autohomecar__wKgFVlgm-paAZe57AAHcwt_dQOA002.jpg","replycount":157,"pagecount":1,"jumppage":1,"updatetime":"20161114150259","lastid":"20161115100000546202"},{"id":546309,"title":"谁把奥迪送到上汽怀抱？","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g16/M03/9C/68/160x120_0_autohomecar__wKjBx1goovGATs6yAADSvxMFysk028.jpg","replycount":270,"pagecount":1,"jumppage":1,"updatetime":"20161114141732","lastid":"20161115093000546309"},{"id":543494,"title":"能不能翻身？苑叔聊2017款阿特兹","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g5/M0B/98/8B/160x120_0_autohomecar__wKjB0lglxvCAFv4WAAgbq7NSo2w004.jpg","replycount":395,"pagecount":1,"jumppage":1,"updatetime":"20161114102309","lastid":"20161115090000543494"},{"id":546436,"title":"东南亚人买什么车？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g20/M14/7C/14/160x120_0_autohomecar__wKjBw1gpXuOAGebYAAD8SFniEFQ553.jpg","replycount":420,"pagecount":1,"jumppage":1,"updatetime":"20161114155130","lastid":"20161115073000546436"},{"id":546486,"title":"上汽、奥迪联姻的来龙去脉","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g7/M14/9D/21/160x120_0_autohomecar__wKjB0FgpfZaAXXTpAAC8FoHWmOM632.jpg","replycount":264,"pagecount":1,"jumppage":1,"updatetime":"20161115091410","lastid":"20161115060500546486"},{"id":546374,"title":"10月新能源市场增势四连降 普混热持续","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g21/M06/7C/71/160x120_0_autohomecar__wKgFWlgpMo-AOgrMAAC52-OPCTQ105.jpg","replycount":291,"pagecount":1,"jumppage":1,"updatetime":"20161114132643","lastid":"20161115000100546374"},{"id":546234,"title":"16.3 万起,非洲双缸想靠什么赢得市场？","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g18/M14/96/22/160x120_0_autohomecar__wKgH2VgnysWAJIQqAAOZ2-oX65A201.JPG","replycount":195,"pagecount":1,"jumppage":1,"updatetime":"20161113160433","lastid":"20161114230000546234"},{"id":545846,"title":"碳纤维外观升级的\u201c北美黑马\u201d-MTC篇","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M06/78/92/160x120_0_autohomecar__wKjBwVgkMK2AX7ytAAEoeoXu1BU961.jpg","replycount":19,"pagecount":1,"jumppage":1,"updatetime":"20161115103850","lastid":"20161114223000545846"},{"id":546204,"title":"德国佬在中囯","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g11/M14/9A/D3/160x120_0_autohomecar__wKgH4Vgm_QmAC80kABHFjeuDOcQ187.jpg","replycount":195,"pagecount":1,"jumppage":1,"updatetime":"20161113203834","lastid":"20161114220000546204"},{"id":546326,"title":"车企爱玩速度与激情？高性能部门你造吗","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g5/M0A/98/8D/160x120_0_autohomecar__wKgHzFgpF_GAXib9AAD2MGPhzWU448.jpg","replycount":110,"pagecount":1,"jumppage":1,"updatetime":"20161114105028","lastid":"20161114213000546326"},{"id":546023,"title":"9个你必买 \u201c世界上最丑的车\u201d的理由","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M0F/99/02/160x120_0_autohomecar__wKgH51gpfmmARRwrAAEHWtjThbw182.jpg","replycount":255,"pagecount":1,"jumppage":1,"updatetime":"20161114170551","lastid":"20161114210000546023"},{"id":546310,"title":"都知道它不是奔驰，但还是和想象中不同","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g8/M15/9B/B4/160x120_0_autohomecar__wKgHz1gpNWaAMxXyAAXg8kn32L4018.jpg","replycount":301,"pagecount":1,"jumppage":1,"updatetime":"20161114122841","lastid":"20161114203000546310"},{"id":546452,"title":"现在汽车造型设计怎么都由圆变方了？","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M03/93/FD/160x120_0_autohomecar__wKgH2FgpZ9GAZMQpAAO9Cl6xaGU169.png","replycount":217,"pagecount":1,"jumppage":1,"updatetime":"20161114170633","lastid":"20161114200000546452"},{"id":546475,"title":"2016年美国口碑最差的8款车","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g14/M04/9D/B7/160x120_0_autohomecar__wKgH5FgpjzuAEjfMAAHE6b3oUE4344.jpg","replycount":482,"pagecount":1,"jumppage":1,"updatetime":"20161114181738","lastid":"20161114190000546475"},{"id":546450,"title":"科雷傲\u2014\u2014雷诺最后的好牌？","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g9/M10/9B/B9/160x120_0_autohomecar__wKgH0FgpZzWABNj4AAC6ZY0JeVc800.jpg","replycount":261,"pagecount":1,"jumppage":1,"updatetime":"20161114180348","lastid":"20161114190000546450"},{"id":546420,"title":"试驾-传奇的印第安侦察兵","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M0D/7D/32/160x120_0_autohomecar__wKjBwVgpghmAEeiGAATV6sXnTTk500.jpg","replycount":69,"pagecount":1,"jumppage":1,"updatetime":"20161114172132","lastid":"20161114180000546420"},{"id":546183,"title":"美媒测试油表亮灯能跑多远？（轿车篇）","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g12/M0B/9F/6D/160x120_0_autohomecar__wKgH4lgpfuqADgFsAAE1fgxtnrM598.jpg","replycount":398,"pagecount":1,"jumppage":1,"updatetime":"20161114170755","lastid":"20161114173500546183"},{"id":545973,"title":"竟然有中国品牌在用宝马发动机？","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g7/M0C/9C/F5/160x120_0_autohomecar__wKjB0FgpZryAXQfOAAHvfDds7ig790.jpg","replycount":735,"pagecount":1,"jumppage":1,"updatetime":"20161114152446","lastid":"20161114163000545973"},{"id":546334,"title":"奇瑞捷豹路虎助10月在华销量再破万辆","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g23/M12/7D/61/160x120_0_autohomecar__wKjBwFgpId6AcnKCAAOmrOYPZbo945.jpg","replycount":270,"pagecount":1,"jumppage":1,"updatetime":"20161114103055","lastid":"20161114160000546334"},{"id":546188,"title":"偏执狂发作 于是本田创造了这件尤物","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M02/94/81/160x120_0_autohomecar__wKjBxlgm1suABUTVAAHINrr-65Q331.jpg","replycount":326,"pagecount":1,"jumppage":1,"updatetime":"20161114131706","lastid":"20161114150000546188"},{"id":546260,"title":"从专注运动到阐释运动 解读全新MG ZS","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g5/M12/97/99/160x120_0_autohomecar__wKgHzFgn8dWACUbaAAEwOG_PZG4056.jpg","replycount":103,"pagecount":1,"jumppage":1,"updatetime":"20161114110617","lastid":"20161114143000546260"},{"id":546336,"title":"盘点2017年将消失的车型 或让位或终结","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g18/M07/97/62/160x120_0_autohomecar__wKgH2VgpKO6AFQyMAAhprdJE7cE041.jpg","replycount":148,"pagecount":1,"jumppage":1,"updatetime":"20161114110107","lastid":"20161114140000546336"}]}
     */

    private int returncode;
    private String message;
    /**
     * total : 11882
     * isloadmore : true
     * list : [{"id":546680,"title":"三星80亿美元收购哈曼，向汽车领域扩张","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g22/M14/7B/30/160x120_0_autohomecar__wKgFVlgqrI-AZGy3AADnXhAii1k636.jpg","replycount":24,"pagecount":1,"jumppage":1,"updatetime":"20161115144150","lastid":"20161115150000546680"},{"id":546454,"title":"斯柯达柯迪亚克 中文名会否再次拌了脚 ","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g23/M06/7E/69/160x120_0_autohomecar__wKgFXFgpakGAbFgjAALRR5WeX0M171.jpg","replycount":121,"pagecount":1,"jumppage":1,"updatetime":"20161115095433","lastid":"20161115143000546454"},{"id":546523,"title":"众泰竟然是中国小型SUV开山鼻祖？","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g13/M10/9E/E8/160x120_0_autohomecar__wKgH41gqei-AF87eAAG3_NaCl3w770.jpg","replycount":49,"pagecount":1,"jumppage":1,"updatetime":"20161115110001","lastid":"20161115140000546523"},{"id":546451,"title":"2017款大众高尔夫 它叫高8还是高7.5？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g12/M12/9E/B8/160x120_0_autohomecar__wKjBy1gqmdaAcnvrAAeJv8PGCV8377.jpg","replycount":120,"pagecount":1,"jumppage":1,"updatetime":"20161115131504","lastid":"20161115130000546451"},{"id":546446,"title":"体验宝马7系E38--男人的蓝天白云梦！","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g15/M10/9D/DC/160x120_0_autohomecar__wKjByFgpb5mASjq1AAICcKnMya0912.jpg","replycount":81,"pagecount":1,"jumppage":1,"updatetime":"20161114160246","lastid":"20161115120000546446"},{"id":546592,"title":"大众销量依赖中国市场 新SUV帮忙or添乱","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g22/M12/7E/FB/160x120_0_autohomecar__wKgFW1gqekuAT4miAARhDOwCPjo968.jpg","replycount":427,"pagecount":1,"jumppage":1,"updatetime":"20161115110028","lastid":"20161115114500546592"},{"id":546555,"title":"银十的喜与忧|车市10月销量数据报告","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g19/M09/7D/65/160x120_0_autohomecar__wKjBxFgqUWGAQ3d-AAN7Q5B1FIU247.jpg","replycount":67,"pagecount":1,"jumppage":1,"updatetime":"20161115095934","lastid":"20161115110000546555"},{"id":546560,"title":"问答集锦：10万预算能买到后驱车吗？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g18/M08/9D/4E/160x120_0_autohomecar__wKjBxVgqZAOAOHB6AAP5hrBYysQ720.jpg","replycount":154,"pagecount":1,"jumppage":1,"updatetime":"20161115092557","lastid":"20161115103000546560"},{"id":546202,"title":"5-6万能买辆什么样的二手车？--德系篇","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M12/77/B4/160x120_0_autohomecar__wKgFVlgm-paAZe57AAHcwt_dQOA002.jpg","replycount":157,"pagecount":1,"jumppage":1,"updatetime":"20161114150259","lastid":"20161115100000546202"},{"id":546309,"title":"谁把奥迪送到上汽怀抱？","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g16/M03/9C/68/160x120_0_autohomecar__wKjBx1goovGATs6yAADSvxMFysk028.jpg","replycount":270,"pagecount":1,"jumppage":1,"updatetime":"20161114141732","lastid":"20161115093000546309"},{"id":543494,"title":"能不能翻身？苑叔聊2017款阿特兹","time":"2016-11-15","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g5/M0B/98/8B/160x120_0_autohomecar__wKjB0lglxvCAFv4WAAgbq7NSo2w004.jpg","replycount":395,"pagecount":1,"jumppage":1,"updatetime":"20161114102309","lastid":"20161115090000543494"},{"id":546436,"title":"东南亚人买什么车？","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g20/M14/7C/14/160x120_0_autohomecar__wKjBw1gpXuOAGebYAAD8SFniEFQ553.jpg","replycount":420,"pagecount":1,"jumppage":1,"updatetime":"20161114155130","lastid":"20161115073000546436"},{"id":546486,"title":"上汽、奥迪联姻的来龙去脉","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g7/M14/9D/21/160x120_0_autohomecar__wKjB0FgpfZaAXXTpAAC8FoHWmOM632.jpg","replycount":264,"pagecount":1,"jumppage":1,"updatetime":"20161115091410","lastid":"20161115060500546486"},{"id":546374,"title":"10月新能源市场增势四连降 普混热持续","time":"2016-11-15","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g21/M06/7C/71/160x120_0_autohomecar__wKgFWlgpMo-AOgrMAAC52-OPCTQ105.jpg","replycount":291,"pagecount":1,"jumppage":1,"updatetime":"20161114132643","lastid":"20161115000100546374"},{"id":546234,"title":"16.3 万起,非洲双缸想靠什么赢得市场？","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g18/M14/96/22/160x120_0_autohomecar__wKgH2VgnysWAJIQqAAOZ2-oX65A201.JPG","replycount":195,"pagecount":1,"jumppage":1,"updatetime":"20161113160433","lastid":"20161114230000546234"},{"id":545846,"title":"碳纤维外观升级的\u201c北美黑马\u201d-MTC篇","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M06/78/92/160x120_0_autohomecar__wKjBwVgkMK2AX7ytAAEoeoXu1BU961.jpg","replycount":19,"pagecount":1,"jumppage":1,"updatetime":"20161115103850","lastid":"20161114223000545846"},{"id":546204,"title":"德国佬在中囯","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g11/M14/9A/D3/160x120_0_autohomecar__wKgH4Vgm_QmAC80kABHFjeuDOcQ187.jpg","replycount":195,"pagecount":1,"jumppage":1,"updatetime":"20161113203834","lastid":"20161114220000546204"},{"id":546326,"title":"车企爱玩速度与激情？高性能部门你造吗","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g5/M0A/98/8D/160x120_0_autohomecar__wKgHzFgpF_GAXib9AAD2MGPhzWU448.jpg","replycount":110,"pagecount":1,"jumppage":1,"updatetime":"20161114105028","lastid":"20161114213000546326"},{"id":546023,"title":"9个你必买 \u201c世界上最丑的车\u201d的理由","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M0F/99/02/160x120_0_autohomecar__wKgH51gpfmmARRwrAAEHWtjThbw182.jpg","replycount":255,"pagecount":1,"jumppage":1,"updatetime":"20161114170551","lastid":"20161114210000546023"},{"id":546310,"title":"都知道它不是奔驰，但还是和想象中不同","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g8/M15/9B/B4/160x120_0_autohomecar__wKgHz1gpNWaAMxXyAAXg8kn32L4018.jpg","replycount":301,"pagecount":1,"jumppage":1,"updatetime":"20161114122841","lastid":"20161114203000546310"},{"id":546452,"title":"现在汽车造型设计怎么都由圆变方了？","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M03/93/FD/160x120_0_autohomecar__wKgH2FgpZ9GAZMQpAAO9Cl6xaGU169.png","replycount":217,"pagecount":1,"jumppage":1,"updatetime":"20161114170633","lastid":"20161114200000546452"},{"id":546475,"title":"2016年美国口碑最差的8款车","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g14/M04/9D/B7/160x120_0_autohomecar__wKgH5FgpjzuAEjfMAAHE6b3oUE4344.jpg","replycount":482,"pagecount":1,"jumppage":1,"updatetime":"20161114181738","lastid":"20161114190000546475"},{"id":546450,"title":"科雷傲\u2014\u2014雷诺最后的好牌？","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g9/M10/9B/B9/160x120_0_autohomecar__wKgH0FgpZzWABNj4AAC6ZY0JeVc800.jpg","replycount":261,"pagecount":1,"jumppage":1,"updatetime":"20161114180348","lastid":"20161114190000546450"},{"id":546420,"title":"试驾-传奇的印第安侦察兵","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g22/M0D/7D/32/160x120_0_autohomecar__wKjBwVgpghmAEeiGAATV6sXnTTk500.jpg","replycount":69,"pagecount":1,"jumppage":1,"updatetime":"20161114172132","lastid":"20161114180000546420"},{"id":546183,"title":"美媒测试油表亮灯能跑多远？（轿车篇）","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g12/M0B/9F/6D/160x120_0_autohomecar__wKgH4lgpfuqADgFsAAE1fgxtnrM598.jpg","replycount":398,"pagecount":1,"jumppage":1,"updatetime":"20161114170755","lastid":"20161114173500546183"},{"id":545973,"title":"竟然有中国品牌在用宝马发动机？","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g7/M0C/9C/F5/160x120_0_autohomecar__wKjB0FgpZryAXQfOAAHvfDds7ig790.jpg","replycount":735,"pagecount":1,"jumppage":1,"updatetime":"20161114152446","lastid":"20161114163000545973"},{"id":546334,"title":"奇瑞捷豹路虎助10月在华销量再破万辆","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g23/M12/7D/61/160x120_0_autohomecar__wKjBwFgpId6AcnKCAAOmrOYPZbo945.jpg","replycount":270,"pagecount":1,"jumppage":1,"updatetime":"20161114103055","lastid":"20161114160000546334"},{"id":546188,"title":"偏执狂发作 于是本田创造了这件尤物","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g17/M02/94/81/160x120_0_autohomecar__wKjBxlgm1suABUTVAAHINrr-65Q331.jpg","replycount":326,"pagecount":1,"jumppage":1,"updatetime":"20161114131706","lastid":"20161114150000546188"},{"id":546260,"title":"从专注运动到阐释运动 解读全新MG ZS","time":"2016-11-14","type":"","smallpic":"http://www2.autoimg.cn/newsdfs/g5/M12/97/99/160x120_0_autohomecar__wKgHzFgn8dWACUbaAAEwOG_PZG4056.jpg","replycount":103,"pagecount":1,"jumppage":1,"updatetime":"20161114110617","lastid":"20161114143000546260"},{"id":546336,"title":"盘点2017年将消失的车型 或让位或终结","time":"2016-11-14","type":"","smallpic":"http://www3.autoimg.cn/newsdfs/g18/M07/97/62/160x120_0_autohomecar__wKgH2VgpKO6AFQyMAAhprdJE7cE041.jpg","replycount":148,"pagecount":1,"jumppage":1,"updatetime":"20161114110107","lastid":"20161114140000546336"}]
     */

    private ResultBean result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private int total;
        private boolean isloadmore;
        /**
         * id : 546680
         * title : 三星80亿美元收购哈曼，向汽车领域扩张
         * time : 2016-11-15
         * type :
         * smallpic : http://www2.autoimg.cn/newsdfs/g22/M14/7B/30/160x120_0_autohomecar__wKgFVlgqrI-AZGy3AADnXhAii1k636.jpg
         * replycount : 24
         * pagecount : 1
         * jumppage : 1
         * updatetime : 20161115144150
         * lastid : 20161115150000546680
         */

        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public boolean isIsloadmore() {
            return isloadmore;
        }

        public void setIsloadmore(boolean isloadmore) {
            this.isloadmore = isloadmore;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int id;
            private String title;
            private String time;
            private String type;
            private String smallpic;
            private int replycount;
            private int pagecount;
            private int jumppage;
            private String updatetime;
            private String lastid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSmallpic() {
                return smallpic;
            }

            public void setSmallpic(String smallpic) {
                this.smallpic = smallpic;
            }

            public int getReplycount() {
                return replycount;
            }

            public void setReplycount(int replycount) {
                this.replycount = replycount;
            }

            public int getPagecount() {
                return pagecount;
            }

            public void setPagecount(int pagecount) {
                this.pagecount = pagecount;
            }

            public int getJumppage() {
                return jumppage;
            }

            public void setJumppage(int jumppage) {
                this.jumppage = jumppage;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getLastid() {
                return lastid;
            }

            public void setLastid(String lastid) {
                this.lastid = lastid;
            }
        }
    }
}
