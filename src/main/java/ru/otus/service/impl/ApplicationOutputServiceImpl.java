package ru.otus.service.impl;

import ru.otus.service.ApplicationOutputService;

public class ApplicationOutputServiceImpl implements ApplicationOutputService {
    @Override
    public void printWords(String words) {
        System.out.println(words);
    }
}
