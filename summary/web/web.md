# web

## 注解

### 参数

|              | 概念     | 默认值 |
| ------------ | -------- | ------ |
| required     | 是否必须 | true   |
| name         | 匹配名称 | ""     |
| value        | 匹配值   | ""     |
| defaultValue | 默认值   |        |

**源码中name的别名是value，value的别名是name（同时使用时需要值一样，否则接收请求时会报错）**

- @RequestBody

  > 获取方法体中的数据
  >
  > **Get不可用，Get方法没有方法体**
  >
  > 属性：required

- @RequestParam

  > 获取跟在url之后的数据
  >
  > 属性：all

- @RequestAttribute

  > 获取setAttribute中的数据
  >
  > 属性：required、name、value

- @RequestHeader

  > 获取请求头中的数据
  >
  > 属性：all

### 方法

- @RequestMapping

  > 匹配发送的请求
  >
  > 属性：
  >
  > - name：名称（当注释用）
  > - value：匹配的请求名
  > - path：同value
  > - method：要匹配的请求的类型
  > - params：匹配请求的params
  > - headers：匹配请求的headers
  > - consumes：匹配请求的提交内容类型（Content-Type）
  > - produces：指定返回值的类型

  **源码中name的别名是value，value的别名是name（同时使用时需要值一样，否则编译时会报错）**

- @PostMapping、@GetMapping、@PatchMapping、@DeleteMapping、@PutMapping

  > 匹配发送的请求，相当于RequestMapping（method=注解名前缀）