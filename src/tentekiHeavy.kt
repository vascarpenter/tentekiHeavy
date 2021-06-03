import java.util.*
import javax.swing.JFrame

data class DrugElement(var mName: String, var mWater: Int, var mEnergy: Int, var mNa: Double, var mK: Double)
{
    override fun toString(): String
    {
        if (mName.startsWith("*"))
            return mName

        return mName + String.format(" (%dml)", mWater)
    }
}

var drugs: Vector<DrugElement> = Vector<DrugElement>()
var patients: Vector<DrugElement> = Vector<DrugElement>()

fun main(args: Array<String>)
{
    val f = JFrame("点滴君kotlin(heavy)")
    val g = gui()
    f.contentPane = g.panel
    f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    f.setSize(800, 500)
    f.isResizable = true
    f.setLocationRelativeTo(null)
    f.isVisible = true

    addDrugs()

    g.list1.setListData(drugs)
    g.list2.setListData(patients)

    g.list1.addListSelectionListener {
        if (it.valueIsAdjusting) return@addListSelectionListener
        if (g.list1.selectedValue != null)
            addToPatient(g, g.list1.selectedValue as DrugElement)
    }
    g.list2.addListSelectionListener {
        if (it.valueIsAdjusting) return@addListSelectionListener
        if (g.list2.selectedValue != null)
            removeFromPatient(g, g.list2.selectedValue as DrugElement)
    }
}

fun addDrugs()
{
    drugs.add(DrugElement("*グルコース", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("10% グルコース", 500, 200, 0.0, 0.0))
    drugs.add(DrugElement("5% グルコース", 500, 100, 0.0, 0.0))
    drugs.add(DrugElement("50% グルコース", 20, 40, 0.0, 0.0))
    drugs.add(DrugElement("50% グルコース", 200, 400, 0.0, 0.0))

    drugs.add(DrugElement("*脂質", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("イントラリポス 20%", 100, 200, 0.0, 0.0))

    drugs.add(DrugElement("*アミノ酸", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("アミノレバン", 500, 7, 0.0, 0.0))
    drugs.add(DrugElement("アミパレン", 200, 0, 0.0, 0.0))
    drugs.add(DrugElement("マックアミン", 500, 0, 10.0, 10.0))
    drugs.add(DrugElement("プロテアミン 12x", 200, 136, 30.0, 30.0))
    drugs.add(DrugElement("モリヘパン", 500, 76, 1.5, 0.0))
    drugs.add(DrugElement("アミカリック", 500, 0, 15.0, 12.5))

    drugs.add(DrugElement("*ナトリウム", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("10% 塩化ナトリウム", 20, 0, 34.0, 0.0))

    drugs.add(DrugElement("*カリウム", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("1mol 塩化カリウム", 20, 0, 0.0, 40.0))
    drugs.add(DrugElement("アスパラK", 10, 0, 0.0, 10.0))

    drugs.add(DrugElement("*初期輸液", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("ソリタT1", 500, 52, 45.0, 0.0))
    drugs.add(DrugElement("フィジオゾール 1L", 500, 52, 45.0, 0.0))

    drugs.add(DrugElement("*細胞内液", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("ソリタT2", 500, 64, 42.0, 10.0))
    drugs.add(DrugElement("フィジオゾール 2S", 500, 29, 33.7, 15.0))

    drugs.add(DrugElement("*等張液", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("ソリタT3/ハルトマンG3", 500, 86, 17.5, 10.0))
    drugs.add(DrugElement("ソリタ T3G", 500, 150, 17.5, 10.0))
    drugs.add(DrugElement("フィジオ3号", 500, 200, 17.5, 10.0))
    drugs.add(DrugElement("ソリタックスH", 500, 250, 25.0, 15.0))

    drugs.add(DrugElement("*細胞外液", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("生理食塩水", 100, 0, 15.4, 0.0))
    drugs.add(DrugElement("生理食塩水", 20, 0, 3.1, 0.0))
    drugs.add(DrugElement("生理食塩水", 500, 0, 77.0, 0.0))
    drugs.add(DrugElement("ヴィーンD", 500, 100, 65.0, 2.0))
    drugs.add(DrugElement("ヴィーンF", 500, 0, 65.0, 4.0))
    drugs.add(DrugElement("ハルトマンG3", 500, 86, 17.5, 10.0))
    drugs.add(DrugElement("ポタコールR", 500, 100, 65.0, 2.0))

    drugs.add(DrugElement("*高カロリー輸液", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("ハイカリック1", 700, 480, 0.0, 21.0))
    drugs.add(DrugElement("ハイカリック2", 700, 700, 0.0, 21.0))
    drugs.add(DrugElement("ハイカリック3", 700, 1000, 0.0, 21.0))
    drugs.add(DrugElement("PNツイン1", 1000, 560, 51.0, 30.0))
    drugs.add(DrugElement("PNツイン2", 1100, 924, 56.0, 33.0))
    drugs.add(DrugElement("トリパレン1", 600, 560, 3.0, 27.0))
    drugs.add(DrugElement("トリパレン2", 600, 700, 35.0, 27.0))
    drugs.add(DrugElement("ユニカリック", 1000, 500, 40.0, 27.0))

    drugs.add(DrugElement("*そのほか", 0, 0, 0.0, 0.0))
    drugs.add(DrugElement("グリセオール", 300, 0, 46.0, 0.0))
    drugs.add(DrugElement("低分子量デキストラン", 250, 0, 32.5, 1.0))
}

fun addToPatient(g: gui, drug: DrugElement)
{
    if (drug.mName.startsWith("*")) return

    patients.add(drug)
    g.list2.setListData(patients)
    refreshParams(g)
}

fun removeFromPatient(g: gui, drug: DrugElement)
{
    patients.remove(drug)
    g.list2.setListData(patients)
    refreshParams(g)
}


fun refreshParams(g: gui)
{
    var ptWater = 0
    var ptNa = 0.0
    var ptK = 0.0
    var ptEne = 0

    // 以前は追加・削除のたびにグローバル変数に＋ーしていたが、この方が遅いが誤差がでなくなる
    for (i in patients)
    {
        ptWater += i.mWater
        ptEne += i.mEnergy
        ptNa += i.mNa
        ptK += i.mK
    }

    g.waterLabel.text = ptWater.toString()
    g.eneLabel.text = ptEne.toString()
    g.naLabel.text = String.format("%3.1f", ptNa)
    g.kLabel.text = String.format("%3.1f", ptK)
    g.naclLabel.text = String.format("%3.1f", ptNa * 16.78 / 1000 * ptWater / 1000)

    g.list1.repaint()
    g.list2.repaint()
}