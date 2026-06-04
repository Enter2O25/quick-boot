# Changelog

所有重要变更会记录在这里。版本号建议遵循语义化版本，并在 GitHub Releases 中同步发布。

## [Unreleased]

### Added

- 增加 GitHub Actions CI，默认在 push 和 pull request 时执行 Maven 编译。
- 增加 `CONTRIBUTING.md`，说明贡献流程、验证命令和提交格式。
- 增加 `SECURITY.md`，说明安全问题报告方式和配置安全约定。
- 增加 `application-local.example.yaml`，作为本地开发配置模板。
- 增加 Quick Boot 与 ruoyi-vue-pro 的差异说明，补充项目定位、模块取舍和适用场景。

### Changed

- 将公开配置中的第三方密钥、API Key 和密码改为环境变量占位符。
- 将 `application-local.yaml` 加入 `.gitignore`，避免本地私有配置继续进入公开提交。
