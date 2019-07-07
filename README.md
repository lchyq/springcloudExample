这是一个springCloud项目
1.编写springBoot版hello world,编写自测代码
2.增加天气预报系统子模块
3.增加根据城市id和城市名称获取天气信息的接口
4.使用redis缓存系统（单实例）来缓存天气数据，避免频繁调用第三方接口
5.使用quartz来定时的刷新缓存数据
6.增加thymeleaf模板引擎，渲染天气数据












疑问部分
1.了解一下mockMvc的作用
2.springBoot内置jacson序列化框架。
可以直接使用objectMapper来将json数据转化为对应的bean对象，需要注意属性名称需要一一对应
3.redis3.x版本可能链接时会出现保护模式，启动时使用 --protected-mode no参数即可
4.使用spring自带的classPathResource类来读取类路径下文件
5.使用java自带的JAXBContext来解析xml数据
6.使用@XmlRootElement,@xmlAttribute @xmlElement,@XmlAccessorType注解来映射xml中的数据
7.解析xml的过程为：
    读取类路径下的文件，获取数据流之后，将读取到的数据转换为String数据
    使用JAXBContext生成想要生成对象的实例
    使用unmarshaller.unmarshal方法来将string数据转换为obj对象
8.模板引擎渲染数据时可能出现乱码，可能的原因是使用流的时候，需要指定数据编码。