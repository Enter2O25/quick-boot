# Quick Boot

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue)
![License](https://img.shields.io/badge/License-MIT-green)

English | [中文](#quick-boot-中文)

Quick Boot is a lightweight enterprise backend scaffolding project based on **Java 17 + Spring Boot 3**. It is designed for admin systems, SaaS platforms, business management systems, API services, and reusable backend infrastructure modules.

This project is refined from [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro). Quick Boot keeps common backend foundations, adjusts module boundaries, simplifies the project structure, and focuses on becoming a lighter Spring Boot 3 backend template.

Thanks to the `ruoyi-vue-pro` project and its community for their open-source contributions.

## Goals

Quick Boot is not intended to be a large all-in-one business platform. Its goal is to provide a clean, extensible, and maintainable Spring Boot backend foundation.

It is suitable for:

* Starting Java backend projects quickly
* Building enterprise admin APIs
* Reusing common backend infrastructure modules
* Learning and extending Spring Boot 3 projects
* Building platforms with security, tenant isolation, logs, scheduled jobs, monitoring, and infrastructure features

## Origin And Credits

Quick Boot is based on [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro), with simplification and secondary development.

`ruoyi-vue-pro` is a mature open-source rapid development platform with authentication, system management, infrastructure, workflow, mall, CRM, ERP, MES, AI, IoT, and many other enterprise features. Quick Boot trims and reorganizes those foundations, mainly keeping backend scaffolding, framework components, system management, and infrastructure modules.

For detailed positioning, module differences, and recommended scenarios, see [Quick Boot 与 ruoyi-vue-pro 的差异说明](docs/quick-boot-vs-ruoyi-vue-pro.md).

Quick Boot will preserve the required open-source credits and follow the original project's license requirements where applicable.

## Features

* **Spring Boot 3 + Java 17**: Modern Java backend stack
* **Multi-module project structure**: Clear separation between dependency management, framework components, business modules, and server entrypoint
* **Centralized dependency management**: Managed through `quick-dependencies`
* **Reusable starter components**: Common backend capabilities are packaged as starter modules
* **MyBatis Plus integration**: Simplifies database access and CRUD development
* **Redis integration**: Supports caching and distributed capabilities
* **Druid connection pool**: Provides SQL monitoring and slow SQL tracking
* **Security foundation**: Provides backend authentication and permission foundations
* **WebSocket support**: Useful for notifications and real-time messaging
* **Monitoring support**: Integrates Actuator and Spring Boot Admin
* **Scheduled jobs**: Integrates Quartz for job scheduling
* **Message queue extension points**: Supports RabbitMQ, Kafka, RocketMQ extension scenarios
* **Excel utilities**: Supports common import and export use cases
* **Tenant and data permission foundations**: Suitable for SaaS and enterprise permission isolation

## Tech Stack

| Category | Technology |
| --- | --- |
| Language | Java 17 |
| Core framework | Spring Boot 3 |
| ORM | MyBatis Plus |
| Database | MySQL |
| Cache | Redis |
| Connection pool | Druid |
| Scheduler | Quartz |
| Message queue | RabbitMQ / Kafka / RocketMQ |
| Monitoring | Spring Boot Actuator / Spring Boot Admin |
| Build tool | Maven |

## Project Structure

```text
quick-boot
├── quick-dependencies
│   └── Centralized dependency management
│
├── quick-framework
│   └── Framework components and reusable starter modules
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
│   └── System management module
│
├── quick-module-infra
│   └── Infrastructure module
│
├── quick-server
│   └── Backend service entrypoint
│
└── sql
    └── Database initialization scripts
```

## Quick Start

### Requirements

* JDK 17+
* Maven 3.8+
* MySQL 8.0+
* Redis 6.0+
* Docker Compose 2.x (optional, for local infrastructure)

### 1. Clone

```bash
git clone https://github.com/Enter2O25/quick-boot.git
cd quick-boot
```

### 2. Start Local Infrastructure With Docker Compose

You can start MySQL and Redis with Docker Compose:

```bash
cp .env.example .env
docker compose up -d mysql redis
```

The MySQL container creates the `quick_boot` database and imports `sql/mysql/dev-scaffolding.sql` on the first startup. If you need to rerun the initialization script, remove the named volume first:

```bash
docker compose down -v
docker compose up -d mysql redis
```

Check service status:

```bash
docker compose ps
```

Default local connection values:

| Service | Host | Port | Database / Password |
| --- | --- | --- | --- |
| MySQL | `127.0.0.1` | `3306` | database `quick_boot`, root password `quick_boot_dev` |
| Redis | `127.0.0.1` | `6379` | no password |

### 3. Initialize Database Manually

Create a database:

```sql
CREATE DATABASE quick_boot DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Import the SQL scripts under:

```text
sql/mysql/
```

Skip this manual step if you already used Docker Compose and the MySQL volume was empty on first startup.

### 4. Configure Local Environment

Recommended configuration files:

```text
application.yaml
application-local.example.yaml
application-local.yaml
```

* `application.yaml`: Shared configuration committed to the repository
* `application-local.example.yaml`: Public local configuration template
* `application-local.yaml`: Private local configuration for database, Redis, and third-party secrets

Copy the example file before local development:

```bash
cp quick-server/src/main/resources/application-local.example.yaml \
  quick-server/src/main/resources/application-local.yaml
```

Then update local database and Redis settings:

```yaml
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://${MYSQL_HOST:127.0.0.1}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:quick_boot}?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&nullCatalogMeansCurrent=true
          username: ${MYSQL_USERNAME:root}
          password: ${MYSQL_PASSWORD:}

  data:
    redis:
      host: ${REDIS_HOST:127.0.0.1}
      port: ${REDIS_PORT:6379}
      database: ${REDIS_DATABASE:0}
      password: ${REDIS_PASSWORD:}
```

Do not commit real database passwords, Redis passwords, API keys, tokens, or third-party platform secrets.

### 5. Run

Run from your IDE:

```text
quick-server/src/main/java/com/liujl/quick/server/QuickServerApplication.java
```

Or run with Maven:

```bash
mvn clean install -DskipTests
cd quick-server
mvn spring-boot:run
```

Default port:

```text
48080
```

Visit:

```text
http://localhost:48080
```

## Open Source Maintenance

Quick Boot is prepared as a long-term open-source project:

* GitHub Actions CI is enabled
* `CONTRIBUTING.md` documents contribution workflow
* `SECURITY.md` documents security reporting and secret handling
* `CHANGELOG.md` tracks important changes
* Public configuration files use environment variable placeholders
* `application-local.yaml` is ignored and should remain private

## Roadmap

Planned improvements:

* Improve README and module documentation
* Add Docker Compose for one-command local infrastructure setup
* Add API documentation and sample endpoints
* Add unit and integration tests
* Improve GitHub Actions checks
* Add starter usage examples
* Document permission, tenant, and data permission modules
* Improve release notes and changelog workflow
* Provide frontend-backend integration examples

## AI-Assisted Maintenance Plan

Quick Boot plans to use AI-assisted tooling for:

* Generating and improving unit tests
* Reviewing Pull Requests
* Refactoring framework and starter modules
* Detecting security and configuration risks
* Improving README, module docs, and usage examples
* Generating changelogs and release notes
* Maintaining issues, TODOs, and technical debt
* Improving readability, testability, and maintainability

## Contribution Areas

Contributions are welcome in the following areas:

* Bug fixes
* Documentation improvements
* Test coverage
* Starter design improvements
* Docker / CI / release automation
* Local development experience
* More business module examples
* Simplifying unnecessary modules and historical code
* Spring Boot 3 compatibility and stability improvements

## Commit Convention

Recommended commit format:

```text
feat: add new feature
fix: fix issue
docs: update documentation
style: adjust code style
refactor: refactor code
test: add or update tests
chore: update build, dependency, or tooling
```

Examples:

```text
feat: add redis starter example
fix: resolve quartz initialization error
docs: update quick start guide
```

## License

This project is licensed under the MIT License.

This project is refined from [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro). Thanks to the original authors and community.

---

# Quick Boot 中文

[English](#quick-boot) | 中文

Quick Boot 是一个基于 **Java 17 + Spring Boot 3** 的企业级后端快速开发脚手架，面向中后台系统、SaaS 管理平台、业务管理系统、API 服务和可复用后端基础模块的快速搭建场景。

本项目基于开源项目 [YunaiV/ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 进行精简、整理和二次封装，保留后端工程中常用的基础能力，并对项目结构、模块边界和 starter 组件进行调整，目标是沉淀一套更轻量、更适合作为后端基础脚手架的 Spring Boot 3 工程模板。

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

`ruoyi-vue-pro` 是一个成熟的开源快速开发平台，提供权限认证、系统管理、基础设施、工作流、商城、CRM、ERP、MES、AI、IoT 等大量企业级功能。Quick Boot 在此基础上进行了裁剪和整理，主要保留后端脚手架、框架组件、系统管理、基础设施等核心能力，用于构建更轻量的 Java 后端快速开发模板。

更详细的定位、模块差异和适用场景，请阅读 [Quick Boot 与 ruoyi-vue-pro 的差异说明](docs/quick-boot-vs-ruoyi-vue-pro.md)。

本项目会尽量保留原项目的开源说明与致谢，并遵循原项目的开源协议要求。

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
* **消息队列扩展**：支持 RabbitMQ、Kafka、RocketMQ 等扩展场景
* **Excel 工具能力**：支持常见导入导出场景
* **多租户与数据权限**：适合 SaaS 系统和企业级权限隔离场景

## 技术栈

| 分类 | 技术 |
| --- | --- |
| 语言 | Java 17 |
| 核心框架 | Spring Boot 3 |
| ORM | MyBatis Plus |
| 数据库 | MySQL |
| 缓存 | Redis |
| 连接池 | Druid |
| 任务调度 | Quartz |
| 消息队列 | RabbitMQ / Kafka / RocketMQ |
| 监控 | Spring Boot Actuator / Spring Boot Admin |
| 构建工具 | Maven |

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

* JDK 17+
* Maven 3.8+
* MySQL 8.0+
* Redis 6.0+
* Docker Compose 2.x（可选，用于本地基础设施）

### 1. 克隆项目

```bash
git clone https://github.com/Enter2O25/quick-boot.git
cd quick-boot
```

### 2. 使用 Docker Compose 启动本地基础设施

可以使用 Docker Compose 启动 MySQL 和 Redis：

```bash
cp .env.example .env
docker compose up -d mysql redis
```

MySQL 容器会在首次启动时创建 `quick_boot` 数据库，并导入 `sql/mysql/dev-scaffolding.sql`。如果需要重新执行初始化脚本，先删除命名数据卷：

```bash
docker compose down -v
docker compose up -d mysql redis
```

查看服务状态：

```bash
docker compose ps
```

默认本地连接信息：

| 服务 | 地址 | 端口 | 数据库 / 密码 |
| --- | --- | --- | --- |
| MySQL | `127.0.0.1` | `3306` | 数据库 `quick_boot`，root 密码 `quick_boot_dev` |
| Redis | `127.0.0.1` | `6379` | 无密码 |

### 3. 手动初始化数据库

创建数据库：

```sql
CREATE DATABASE quick_boot DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

导入 `sql/mysql/` 目录下的 SQL 脚本。

如果已经使用 Docker Compose，并且 MySQL 数据卷在首次启动时为空，可以跳过本手动步骤。

### 4. 修改本地配置

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

复制本地配置模板：

```bash
cp quick-server/src/main/resources/application-local.example.yaml \
  quick-server/src/main/resources/application-local.yaml
```

重点修改数据库和 Redis 配置：

```yaml
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://${MYSQL_HOST:127.0.0.1}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:quick_boot}?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&nullCatalogMeansCurrent=true
          username: ${MYSQL_USERNAME:root}
          password: ${MYSQL_PASSWORD:}

  data:
    redis:
      host: ${REDIS_HOST:127.0.0.1}
      port: ${REDIS_PORT:6379}
      database: ${REDIS_DATABASE:0}
      password: ${REDIS_PASSWORD:}
```

不要将真实数据库密码、Redis 密码、API Key、Token 或第三方平台密钥提交到公开仓库。

### 5. 启动项目

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

访问地址：

```text
http://localhost:48080
```

## 开源维护准备度

为了让项目更适合作为公开开源项目长期维护，本仓库约定：

* 通过 GitHub Actions 执行 CI 检查
* 通过 `CONTRIBUTING.md` 说明贡献流程
* 通过 `SECURITY.md` 说明安全问题报告方式
* 通过 `CHANGELOG.md` 记录版本变化
* 公开配置只保留环境变量占位符
* `application-local.yaml` 只用于本地开发，不提交到仓库

## 开发计划

后续计划持续完善以下内容：

* 完善 README 和模块文档
* 增加 Docker Compose 一键启动环境
* 增加接口文档和示例接口
* 增加单元测试和集成测试
* 优化 GitHub Actions 检查
* 补充 starter 模块的使用示例
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
