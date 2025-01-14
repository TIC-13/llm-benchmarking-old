package ai.luxai.benchmarkingllm.utils.benchmark.system

import android.app.ActivityManager
import android.content.Context
import android.os.Process

fun getProcessName(context: Context): String? {
    val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val myPid = Process.myPid()
    val runningApps = am.runningAppProcesses ?: return null
    for (processInfo in runningApps) {
        if (processInfo.pid == myPid) {
            return processInfo.processName
        }
    }
    return null
}