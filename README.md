# Quick Boot

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue)
![License](https://img.shields.io/badge/License-MIT-green)

Quick Boot 是一个基于 **Java 17 + Spring Boot 3** 的企业级后端快速开发脚手架，面向中后台系统、SaaS 管理平台、业务管理系统和微服务基础模块的快速搭建场景。

本项目基于开源项目 [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 进行精简、整理和二次封装，保留了后端工程中常用的基础能力，并对项目结构、模块边界和 starter 组件进行调整，目标是沉淀一套更轻量、更适合作为后端基础脚手架的 Spring Boot 3 工程模板。

感谢 [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 项目及其社区的开源贡献。

## 项目目标

Quick Boot 的目标不是做一个“大而全”的业务系统，而是提供一套清晰、可扩展、易维护的 Spring Boot 后端基础工程。

它适合用于：

* 快速启动 Java 后端项目
* 搭建企业级中后台 API 服务
* 沉淀通用技术组件和业务模块
* 作为 Spring Boot 3 项目的学习和二次开发模板
* 构建支持权限、租户、日志、定时任务、监控等能力的基础平台

## 项目来源与致谢

Quick Boot 基于 [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 进行精简和二次开发。

`ruoyi-vue-pro` 是一个优秀的国产开源快速开发平台，提供权限认证、系统管理、基础设施、工作流、商城、CRM、ERP、MES、AI、IoT 等大量企业级功能。Quick Boot 在此基础上进行了裁剪和整理，主要保留后端脚手架、框架组件、系统管理、基础设施等核心能力，用于构建更轻量的 Java 后端快速开发模板。

本项目会尽量保留原项目的开源说明与致谢，并遵循原项目的开源协议要求。感谢原作者和社区对 Java 开源生态的贡献。

## 核心特性

* **Spring Boot 3 + Java 17**：使用现代 Java 后端技术栈
* **多模块工程结构**：清晰拆分依赖管理、框架组件、业务模块和启动服务
* **统一依赖版本管理**：通过 `quick-dependencies` 管理项目依赖版本
* **可复用 starter 组件**：将常用能力封装为独立 starter，方便按需扩展
* **MyBatis Plus 集成**：简化数据库访问和 CRUD 开发
* **Redis 集成**：支持缓存、分布式能力和常用 Redis 操作
* **Druid 连接池**：支持数据库连接池、SQL 监控、慢 SQL 记录等能力
* **安全认证组件**：提供后端权限认证相关基础能力
* **WebSocket 支持**：适用于消息推送、实时通知等场景
* **监控能力**：集成 Actuator、Spring Boot Admin 等监控基础能力
* **定时任务支持**：集成 Quartz，支持任务调度场景
* **消息队列扩展**：预留 RabbitMQ、Kafka、RocketMQ 等消息队列能力
* **Excel 工具能力**：支持常见导入导出场景
* **多租户与数据权限**：适合 SaaS 系统和企业级权限隔离场景

## 技术栈

| 分类   | 技术                                       |
| ---- | ---------------------------------------- |
| 语言   | Java 17                                  |
| 核心框架 | Spring Boot 3                            |
| ORM  | MyBatis Plus                             |
| 数据库  | MySQL                                    |
| 缓存   | Redis                                    |
| 连接池  | Druid                                    |
| 任务调度 | Quartz                                   |
| 消息队列 | RabbitMQ / Kafka / RocketMQ              |
| 监控   | Spring Boot Actuator / Spring Boot Admin |
| 构建工具 | Maven                                    |

## 项目结构

```text
quick-boot
├── quick-dependencies
│   └── 依赖版本统一管理
│
├── quick-framework
│   └── 技术组件与通用 starter 封装
│       ├── quick-common
│       ├── quick-spring-boot-starter-mybatis
│       ├── quick-spring-boot-starter-redis
│       ├── quick-spring-boot-starter-web
│       ├── quick-spring-boot-starter-security
│       ├── quick-spring-boot-starter-websocket
│       ├── quick-spring-boot-starter-monitor
│       ├── quick-spring-boot-starter-protection
│       ├── quick-spring-boot-starter-job
│       ├── quick-spring-boot-starter-mq
│       ├── quick-spring-boot-starter-excel
│       ├── quick-spring-boot-starter-biz-tenant
│       ├── quick-spring-boot-starter-biz-data-permission
│       └── quick-spring-boot-starter-biz-ip
│
├── quick-module-system
│   └── 系统管理模块
│
├── quick-module-infra
│   └── 基础设施模块
│
├── quick-server
│   └── 后端服务启动入口
│
└── sql
    └── 数据库初始化脚本
```

## 快速开始

### 环境要求

请先准备以下环境：

* JDK 17+
* Maven 3.8+
* MySQL 8.0+
* Redis 6.0+

### 1. 克隆项目

```bash
git clone https://github.com/Enter2O25/quick-boot.git
cd quick-boot
```

### 2. 初始化数据库

创建数据库，例如：

```sql
CREATE DATABASE quick_boot DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

然后导入 SQL 脚本：

```text
sql/mysql/quick.sql
sql/mysql/quartz.sql
```

### 3. 修改本地配置

建议使用如下配置方式：

```text
application.yaml
application-local.example.yaml
application-local.yaml
```

其中：

* `application.yaml`：提交到仓库，保存通用配置
* `application-local.example.yaml`：提交到仓库，作为本地配置模板
* `application-local.yaml`：本地开发配置，保存数据库、Redis、第三方平台密钥等信息

本地开发时，复制或修改配置文件：

```text
quick-server/src/main/resources/application-local.yaml
```

重点修改以下配置：

```yaml
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://127.0.0.1:3306/quick_boot?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&nullCatalogMeansCurrent=true
          username: ${MYSQL_USERNAME:root}
          password: ${MYSQL_PASSWORD:}

  data:
    redis:
      host: 127.0.0.1
      port: 6379
      database: 0
      password: ${REDIS_PASSWORD:}
```

> 不建议将真实数据库密码、Redis 密码、第三方平台密钥提交到公开仓库。建议使用环境变量、本地私有配置文件或 `application-local.example.yaml` 管理敏感信息。

### 4. 启动项目

使用 IDE 启动：

```text
quick-server/src/main/java/com/liujl/quick/server/QuickServerApplication.java
```

或使用 Maven 启动：

```bash
mvn clean install -DskipTests
cd quick-server
mvn spring-boot:run
```

默认服务端口：

```text
48080
```

启动后可以访问：

```text
http://localhost:48080
```

## 本地开发建议

建议在 `.gitignore` 中加入：

```gitignore
application-local.yaml
.env
*.log
logs/
target/
.idea/
.DS_Store
```

仓库已经提供本地配置示例：

```text
quick-server/src/main/resources/application-local.example.yaml
```

示例配置中建议只保留占位符，不放真实账号、密码和第三方平台密钥。

如果之前已经将 `application-local.yaml` 提交到仓库，请先将它从 Git 跟踪中移除，并立即轮换其中出现过的真实密钥：

```bash
git rm --cached quick-server/src/main/resources/application-local.yaml
```

## 开源维护准备度

为了让项目更适合作为公开开源项目长期维护，本仓库约定：

* 通过 GitHub Actions 执行 Maven 编译检查
* 通过 `CONTRIBUTING.md` 说明贡献流程
* 通过 `SECURITY.md` 说明安全问题报告方式
* 通过 `CHANGELOG.md` 记录版本变化
* 公开配置只保留环境变量占位符，不提交真实密钥

## 开发计划

后续计划持续完善以下内容：

* 完善 README 和开发文档
* 增加 Docker Compose 一键启动环境
* 增加接口文档和示例接口
* 增加单元测试和集成测试
* 增加 GitHub Actions CI 检查
* 优化 starter 模块的使用示例
* 补充权限、多租户、数据权限等模块的使用说明
* 增加版本发布说明和 Changelog
* 提供前后端联调示例

## AI 辅助维护计划

本项目计划使用 AI 辅助维护以下开源工作：

* 自动生成和改进单元测试
* 对 Pull Request 进行代码审查
* 重构框架层和 starter 组件
* 检查潜在安全问题和配置风险
* 改进 README、模块文档和使用示例
* 生成 Changelog 和 Release Notes
* 辅助维护 Issue、TODO 和技术债务
* 提升项目的可读性、可测试性和可维护性

Quick Boot 是一个长期维护的 Java 后端脚手架项目，希望通过 AI 辅助提升开源维护效率，让项目更容易被其他 Java 开发者理解、使用和贡献。

## 适合贡献的方向

欢迎围绕以下方向提交 Issue 或 Pull Request：

* 修复 bug
* 完善文档
* 增加测试用例
* 优化 starter 设计
* 增加 Docker / CI / Release 自动化
* 改进本地开发体验
* 补充更多业务模块示例
* 精简不必要的业务模块和历史代码
* 提升 Spring Boot 3 兼容性和稳定性

## 提交规范

推荐使用以下提交格式：

```text
feat: 新增功能
fix: 修复问题
docs: 修改文档
style: 代码格式调整
refactor: 代码重构
test: 增加或修改测试
chore: 构建、依赖或工具调整
```

示例：

```text
feat: add redis starter example
fix: resolve quartz initialization error
docs: update quick start guide
```

## License

This project is licensed under the MIT License.

本项目基于 [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 进行精简和二次开发，感谢原项目作者和社区的开源贡献。
