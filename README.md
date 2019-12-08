# -一、实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常

二、要求
系统角色分析及类设计
例如：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
定义每种角色人员的属性，及其操作方法。
属性示例：	人员（编号、姓名、性别）
教师（编号、姓名、性别、所授课程）
学生（编号、姓名、性别、所选课程）
课程（编号、课程名称、上课地点、时间、授课教师）
以上属性仅为示例，同学们可以自行扩展。



三、过程
首先创建一个包，建立登陆和注册类，让用户选择登陆还是注册，用户注册后登陆选择他的身份，进入后填写相关信息，创建一个村信息的文档，将用户填写信息写入，可进行添加、删除、修改、查询等操作。最后打印信息，添加按钮将文件内容读取后，显示信息。

四、流程图
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG785.jpeg)

五、核心代码及注释
public chaxun() {
      JFrame jf = new JFrame("显示符合条件的学生信息");
      //jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      // 创建内容面板
       JPanel panel = new JPanel();
      // 表头（列名）
      //  String[] columnNames ={"序号","学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码" };
      Vector columnNames=createColumnNames();
      //需要查询的符合条件的,用字符串数组f记录
    String [] f = new String [7];
    try{
     FileReader f1 = new FileReader("查询时暂时存放的文件.txt");
     BufferedReader br=new BufferedReader(f1);
     //arry.clear();// 清除原数组列表中的数据
     String t=null;
     while ((t= br.readLine())!= null)
      {
        f=t.split("\\s+");   //要查询的学生信息
      }
      f1.close();
      br.close();
     } catch (IOException e) {
        // TODO 自动生成的 catch 块
     e.printStackTrace();
     }

六、运行截图
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG786.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG787.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG788.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG789.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG790.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG791.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG792.png)
![avatar](https://github.com/zhaohuanxia/Dashiyan1/blob/master/WechatIMG793.png)

七、编程感想
经过此次试验，初步掌握了使用GUI窗体及其组件设计窗体界面，较完成了学生选课过程业务逻辑编程，并且基于文件保存并读取数据，处理异常，了解了创建String类对象，加深了对String类常用方法理解，并且了解了StringBuffer类以及他的常用方法。而且加深了对异常体系结构的概念，了解到了它的用途与模型。在实验中也感受到了自己知识上的漏洞，在接下来的学习中应更加努力。


