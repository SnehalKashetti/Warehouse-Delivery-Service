
# Team‑Wide Prompt Naming Conventions

This document standardizes **names, prefixes, and file layout** for prompts/snippets/agent tasks across repositories.

## 1) Naming Format

`scope.audience.tier.category.action.optionalQualifier`

- **scope**: `java`, `spring`, `k8s`, `cicd`, `sec`, `arch`, `db`, `obs`, `infra`
- **audience**: `dev`, `qa`, `ops`, `arch`, `sec`
- **tier**: `senior`, `std`, `junior`
- **category**: `review`, `rca`, `gen`, `refactor`, `scaffold`, `test`, `perf`, `audit`, `adr`, `plan`
- **action**: `analyze`, `create`, `optimize`, `explain`, `plan`, `fix`
- **optionalQualifier**: technology/pattern, e.g., `hex`, `webflux-r2dbc`, `kafka-dlq`, `pg-tc`, `zgc`, `owasp`

**Case/Separators**
- IDs & prefixes: **kebab-case** (lowercase with dashes)
- Display names: **Title Case** with bullets, e.g., `Spring • Dev • Senior • Scaffold • Feature (Hex)`

## 2) VS Code Snippets

**Prefix pattern**: `p.<scope>.<category>[.<qualifier>]`

Examples: `p.java.review.senior`, `p.spring.scaffold.hex`, `p.cicd.fix.pipeline`, `p.k8s.advice.deploy`.

## 3) IntelliJ Live Templates

- Template name: reader-friendly snake or kebab: `spring_scaffold_hex`
- Group by scope: `Java`, `Spring`, `K8s`, `CI/CD`, `Security`, `Architecture`

## 4) Cursor / Agent Tasks

- `name`: Title Case with bullets
- `id`: kebab-case mirroring scope/audience/tier/category/action
- `tags`: technologies and categories for search/discovery

## 5) Repo Layout

```
prompts/
├─ conventions/
│  └─ CONVENTIONS.md
├─ vscode/
│  └─ java-prompts.code-snippets
├─ intellij/
│  └─ java-prompts-live-templates.xml
├─ cursor/
│  └─ tasks.json
└─ catalog.json
```

## 6) Branch / Commit / PR

- Branch: `feat/<area>-<short>`, `fix/<area>-<issue>`, `refactor/<area>-<target>`
- Commit prefixes: `feat:`, `fix:`, `refactor:`, `perf:`, `test:`, `docs:`, `chore:`, `ci:`
- PR Title: `[<type>] <Scope> • <Goal> (Ref: <Prefix>)`
- PR Description: Context / Changes / Testing / Risks / **Prompt Used**

## 7) ADRs

- File: `ADR-<seq>-<kebab-title>.md` (e.g., `ADR-012-adopt-kafka-for-order-events.md`)
- Footer: `Prompts: p.arch.adr.create`

## 8) Versioning

- Suffix `@v2` if behavior changes materially: `p.spring.scaffold.hex@v2`
- Maintain `prompts/CHANGELOG.md`

## 9) Review Checklist

- Prefix follows `p.<scope>.<category>[.<qualifier>]`
- Description is action-oriented
- Outputs are constrained (Java version, frameworks, files)
- Produces verifiable artifacts (diffs/tests/ADR/YAML)
- Reusable across repos (no hard-coded paths)
