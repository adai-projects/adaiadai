# CompletableFuture

## 概念
- 传统 Future 模式，一旦开始了一个异步操作，就只能等它结束，无法知道执行情况，也不能手动完成或者取消。
- CompletableFuture，是可以"完全控制"的Future。它提供了更多的控制，比如可以手动完成，可以处理异常，还可以把多个Future组合起来，进行更复杂的异步逻辑处理。