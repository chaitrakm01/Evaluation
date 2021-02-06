package com.robosoftin.evaluation.newsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robosoftin.evaluation.newsapp.model.LanguageModel;

public interface LanguageModelRepository extends JpaRepository<LanguageModel, Integer> {
}
