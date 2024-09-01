# Spring Transaction

>

## Transactional

### Propagation

1. `REQUIRED`:

  支持当前事务，如果不存在，则创建新事务；默认。

2. `SUPPORTS`:

  支持当前事务，如果不存在，则以非事务方式执行。

3. `MANDATORY`:

  支持当前事务，如果不存在，则抛出异常。

4. `REQUIRES_NEW`:

  创建一个新的事务，如果存在当前事务，则把当前事务挂起。

5. `NOT_SUPPORTED`:

  以非事务方式运行，如果当前存在事务，则把当前事务挂起。

6. `NEVER`:

  以非事务方式运行，如果当前存在事务，则抛出异常。

7. `NESTED`:

  如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价 `REQUIRED`。
