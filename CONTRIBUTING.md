# Contributing to Quick Boot

感谢你愿意参与 Quick Boot。这个项目目前重点打磨 Java 17 + Spring Boot 3 后端脚手架的基础能力，欢迎围绕文档、测试、starter 组件、配置安全和本地开发体验提交改进。

## 开始之前

1. 先阅读 `README.md`，确认项目定位和模块结构。
2. 本地准备 JDK 17、Maven 3.8+、MySQL 8.0+、Redis 6.0+。
3. 复制 `quick-server/src/main/resources/application-local.example.yaml` 为 `application-local.yaml`，再填写本地连接信息。不要提交真实密码、Token 或第三方平台密钥。

## 提交 Pull Request

1. Fork 仓库并从 `main` 创建分支。
2. 保持修改聚焦，一个 PR 只解决一个问题或一组强相关问题。
3. 提交前至少执行：

```bash
mvn -B -DskipTests compile
```

4. 如果你修改了业务逻辑、starter 行为或公共 API，请补充测试或说明暂时无法测试的原因。
5. PR 描述中请写清楚修改内容、验证方式和潜在影响。

## 推荐提交格式

```text
feat: 新增功能
fix: 修复问题
docs: 修改文档
refactor: 代码重构
test: 增加或修改测试
chore: 构建、依赖或工具调整
```

## 适合贡献的方向

- 完善 README、模块文档和启动示例。
- 增加单元测试、集成测试和 CI 检查。
- 优化 starter 模块的边界和使用示例。
- 清理历史配置、无用代码和安全风险。
- 补充 Docker Compose、本地开发环境和 release 自动化。
