package explore.systemdesign.e3

import java.util.PriorityQueue

class DCLoadBalancer {
    private data class Machine(val machineId: Int, var capacity: Int) {
        val runningApps: MutableList<Int> = mutableListOf()
    }

    private val machineMap = mutableMapOf<Int, Machine>()
    private val capacityHeap = PriorityQueue(compareBy<Machine> { -it.capacity }.thenBy { it.machineId })
    private val appMachineMap = mutableMapOf<Int, Int>()
    private val appLoadUseMap = mutableMapOf<Int, Int>()

    fun addMachine(machineId: Int, capacity: Int) {
        val machine = Machine(machineId, capacity)
        machineMap[machineId] = machine
        capacityHeap.offer(machine)
    }

    fun removeMachine(machineId: Int) {
        val machine = machineMap.remove(machineId)
        capacityHeap.remove(machine)
        machine?.runningApps?.forEach { appId -> addApplication(appId, appLoadUseMap[appId]!!) }
    }

    fun addApplication(appId: Int, loadUse: Int): Int {
        appLoadUseMap[appId] = loadUse
        val machine = capacityHeap.firstOrNull { it.capacity >= loadUse }
        machine?.apply {
            capacity -= loadUse
            runningApps.add(appId)
            appMachineMap[appId] = this.machineId
            capacityHeap.remove(this)
            capacityHeap.offer(this)
            return machineId
        }
        return -1
    }

    fun stopApplication(appId: Int) {
        appMachineMap.remove(appId)?.let { machineId ->
            val machine = machineMap[machineId]!!
            machine.runningApps.remove(appId)
            machine.capacity += appLoadUseMap[appId] ?: 0
            capacityHeap.remove(machine)
            capacityHeap.offer(machine)
        }
    }

    fun getApplications(machineId: Int): List<Int> {
        return machineMap[machineId]?.runningApps?.take(10) ?: emptyList()
    }
}
