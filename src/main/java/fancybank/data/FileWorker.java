package fancybank.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import fancybank.utils.Util;

public class FileWorker implements Runnable, ReadJsonFile, WriteJsonFile {

    WorkType type;
    String filePath;
    Semaphore sem;
    String str;

    /**
     * Create new thread to work on a file. File will be created if not exist. 
     * @param type Either WRITE ot READ. 
     * @param filePath The path of the file to be work on. 
     * @param sem A semaphore object that will be signaled when work is done. 
     * @param str The content that needs to be write or read (work as reference in read mode). 
     */
    public FileWorker(WorkType type, String filePath, Semaphore sem, String str) {
        this.type = type;
        this.filePath = filePath;
        this.sem = sem;
        this.str = str;
    }

    @Override
    public void run() {
        switch(type) {
            case READ:
                str = ReadJsonFile.readFile(filePath);
                sem.release();
                break;
            case WRITE:
                WriteJsonFile.writeFile(filePath, str);
                sem.release();
                break;
            default:
                break;
        }
    }

}
