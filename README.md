# CapX-DynamicMultilevelCachingSystem

## Overview

This project implements a dynamic multilevel caching system in Java. The system supports multiple cache levels with configurable sizes and eviction policies. The supported eviction policies are Least Recently Used (LRU) and Least Frequently Used (LFU).

## Approach

- **Cache Levels**: Allows adding/removing cache levels dynamically. Each level has its size and eviction policy.
- **Eviction Policies**: Implements LRU and LFU eviction policies.
- **Data Management**: Handles data retrieval and insertion, promoting data to higher levels as needed.
- **Dynamic Management**: Supports dynamic addition and removal of cache levels.

## Key Decisions

- **Data Structures**: Used arrays to store cache data for simplicity. Implemented LRU and LFU eviction policies for cache management.
- **Dynamic Levels**: Allowed dynamic addition and removal of cache levels to handle varying requirements.

## How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/dynamic-multilevel-caching-system.git
   ```

## Sample Usage

1. Add cache levels:
   ```java
   cache.addCacheLevel(3, "LRU");
   cache.addCacheLevel(2, "LFU");
