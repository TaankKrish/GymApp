package com.example.gymapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Contact.newInstance] factory method to
 * create an instance of this fragment.
 */
class Contact : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callbtn = view.findViewById<CardView>(R.id.cardCall)
        val whatsAppbtn = view.findViewById<CardView>(R.id.cardWhatsapp)
        val instagrambtn = view.findViewById<CardView>(R.id.cardInstagram)
        val locationbtn = view.findViewById<CardView>(R.id.cardLocation)

        callbtn.setOnClickListener {
            val num = 9874563210
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$num")
            startActivity(intent)
        }

        whatsAppbtn.setOnClickListener {
            val num = 9667220664
            val url = "https://wa.me/$num"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        instagrambtn.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/fitnessfirstindia")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.intagram.android")
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/fitnessfirstindia")))
            }
        }

        locationbtn.setOnClickListener {
            val uri = "https://www.google.com/maps/place/fitness1st/@28.7738233,77.1181254,330m/data=!3m1!1e3!4m15!1m8!3m7!1s0x390d00b85d419375:0x91a298880a1bf556!2sKhera+Kalan,+Delhi!3b1!8m2!3d28.7722431!4d77.1185872!16s%2Fg%2F11gcx0f1l2!3m5!1s0x390d012f4e2f5ccd:0xba2bcb0903b9db51!8m2!3d28.7747407!4d77.1175249!16s%2Fg%2F11s2shyywy?entry=ttu&g_ep=EgoyMDI1MDkxMC4wIKXMDSoASAFQAw%3D%3D"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(uri)
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Contact.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Contact().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}