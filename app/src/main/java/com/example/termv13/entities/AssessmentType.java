package com.example.termv13.entities;

public enum AssessmentType {
    OA {
        @Override
        public String toString() {
            return "Objective Assessment";
        }
    },

    PA {
        @Override
        public String toString() {
            return "Performance Assessment";
        }
    }
}
