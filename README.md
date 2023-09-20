# Snack King Queue Management System

This is a queue management system for the Snack King Food Center, designed to efficiently handle customer queues and pizza stock management. The system is implemented in Java and comes in three versions: Arrays, Classes, and Waiting Queue.

## Table of Contents

- Features
- Getting Started
- Usage
- Task 1: Arrays Version
- Task 2: Classes Version(On class-version branch)
- Task 3: Waiting Queue

## Features

- Three versions of the system: Arrays, Classes, and Waiting Queue.
- Queue management for three cashiers with varying queue capacities.
- Real-time pizza stock tracking and warnings when the stock is low.
- Interactive console-based user interface.
- Data storage and retrieval from text files.
- Sorting customers alphabetically.
- Queue income calculation for the Class version.

## Getting Started

To get started with the Snack King Queue Management System, Clone the repository to your local machine

## Usage
## Task 1: Arrays Version
The Arrays version of the system focuses on basic functionality using arrays. It includes the following features:

- Viewing all queues.
- Viewing queues with at least one empty slot.
- Adding customers to a queue.
- Removing customers from a specific location in a queue.
- Removing served customers and updating pizza count.
- Viewing customers sorted in alphabetical order.
- Storing and loading program data from text files.
- Viewing remaining pizza stock.
- Adding pizza to stock.
- Exiting the program.

## Task 2: Classes Version
The Classes version implements the system using classes, including FoodQueue and Customer. It includes all the features of Task 1 with the addition of queue income calculation. Customers are added to the queue with the minimum length.

## Task 3: Waiting Queue
This version adds a waiting list to the Queue Class version with a maximum size of 5 customers. Customers can be moved from the waiting list to the main queue when there is available space.
