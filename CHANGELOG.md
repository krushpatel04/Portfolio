# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2024.10.15]

### Added

- Created the `WeightTrackerKernel` interface, which defines the core methods for managing exercise data using a map structure.
- Created the enhanced `WeightTracker` interface, which extends `WeightTrackerKernel` and adds secondary methods such as updating, checking, and retrieving exercise data.
- Added kernel methods like `addExercise`, `removeExercise`, `hasExercise`, and more to the `WeightTrackerKernel` interface.
- Added enhanced methods like `updateExercise`, `replaceExerciseData`, and others to the `WeightTracker` interface.

### Changed

- Updated project structure to include the weight tracking app components.
- Updated `settings.json` to ensure package names follow correct structure and to prevent package mismatch issues.

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
