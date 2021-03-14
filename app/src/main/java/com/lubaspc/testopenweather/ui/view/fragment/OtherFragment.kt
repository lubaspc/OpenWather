package com.lubaspc.testopenweather.ui.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import com.lubaspc.testopenweather.databinding.FragmentListBinding
import com.lubaspc.testopenweather.ui.presenter.ListFragmentPresenter
import com.lubaspc.testopenweather.ui.view.activity.MainActivity
import com.lubaspc.testopenweather.ui.view.adapter.WeathersAdapter
import com.lubaspc.testopenweather.utils.init

class OtherFragment(private val testUseCase: TestUseCase) : Fragment() {
    private lateinit var presenter: ListFragmentPresenter
    private lateinit var handle: ListFragmentHandle
    private lateinit var vBind : FragmentListBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        handle = context as MainActivity
        presenter = ListFragmentPresenter(testUseCase)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vBind = FragmentListBinding.inflate(inflater,container,false)
        vBind.rvRequests.init(context!!)
        recyclerAdapter()
        handle.refreshPosition(this::refreshData)
        return vBind.root
    }

    private fun refreshData() {
        presenter.getTests {
            (vBind.rvRequests.adapter as WeathersAdapter).apply {
                weathers = it
                notifyDataSetChanged()
            }
            handle.hideProgress(true)
        }
    }

    private fun recyclerAdapter() {
        presenter.getTests {
            vBind.rvRequests.adapter = WeathersAdapter(it){test->
                handle.clickItem(test)
            }
            handle.hideProgress(true)
        }
    }


    interface ListFragmentHandle{
        fun clickItem(test: Test)
        fun refreshPosition(cb: () -> Unit)
        fun hideProgress(success: Boolean)
    }


}