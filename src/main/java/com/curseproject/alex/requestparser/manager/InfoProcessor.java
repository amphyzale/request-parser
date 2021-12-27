package com.curseproject.alex.requestparser.manager;

import com.curseproject.alex.requestparser.model.Info;

import java.util.List;

public interface InfoProcessor {
    String processInfo(List<Info> info);
}
